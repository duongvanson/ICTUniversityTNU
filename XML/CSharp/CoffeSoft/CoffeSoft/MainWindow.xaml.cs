using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;
using System.Diagnostics;
using System.Xml;
namespace CoffeSoft
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        static string chucvu, name, user;
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            if (!File.Exists(PathsData.setup))
            {
                mnuSide.Visibility = Visibility.Collapsed;
                gvMain.ColumnDefinitions.Remove(gvMain.ColumnDefinitions[0]);
                viewMain.Navigate(new pSetup());
                return;
            }
            if (!checkLogin())
            {
                mnuSide.Visibility = Visibility.Collapsed;
                gvMain.ColumnDefinitions.Remove(gvMain.ColumnDefinitions[0]);
                viewMain.Navigate(new pLogin());
                return;
            }
            loadAccount();
            loadFunction(chucvu, name);
            tbChucVu.Text = chucvu;
            tbName.Text = name;
        }

        private void loadAccount()
        {
            user = File.ReadAllText(PathsData.login);
            XmlDocument doc = new XmlDocument();
            doc.Load(PathsData.accounts);
            var taikhoans = doc.DocumentElement.GetElementsByTagName("taikhoan");
            for (int i = 0; i < taikhoans.Count; i++)
            {
                var x = taikhoans[i];
                if (x.Attributes.GetNamedItem("user").Value == user)
                {
                    chucvu = x.Attributes.GetNamedItem("chucvu").Value;
                    chucvu = chucvu == "quanly" ? "Người quản lý" : "Nhân viên";
                    name = x.FirstChild.FirstChild.Value;
                    return;
                }
            }
        }

        private void loadFunction(string chucvu, string name)
        {
            if (chucvu == "Nhân viên")
            {
                for (int i = 0; i < lboxMenu.Items.Count; i++)
                {
                    var item = lboxMenu.Items[i] as ListBoxItem;
                    if (item.Tag.ToString() == "quanlyhang" || item.Tag.ToString() == "quanlynhanvien")
                    {
                        item.Visibility = Visibility.Collapsed;
                    }
                }
            }
        }

        private bool checkLogin()
        {
            return File.ReadAllText(PathsData.login) != "false";
        }

        private void LboxMenu_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var menu = lboxMenu.SelectedItem as ListBoxItem;
            switch (menu.Tag.ToString())
            {
                case "banhang":
                    
                    break;
                case "quanlyhang":
                    viewMain.Navigate(new pQuanLyHang());
                    break;
                case "quanlynhanvien":
                    break;
                case "logout":
                    logout();
                    break;
                default:
                    break;
            }
        }

        private void logout()
        {
            
        }
    }
}
