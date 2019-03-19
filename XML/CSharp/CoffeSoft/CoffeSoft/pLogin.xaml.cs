using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
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
using System.Xml;

namespace CoffeSoft
{
    /// <summary>
    /// Interaction logic for pLogin.xaml
    /// </summary>
    public partial class pLogin : Page
    {
        public pLogin()
        {
            InitializeComponent();
        }
        private void BtnLogin_Click(object sender, RoutedEventArgs e)
        {
            var user = txtUser.Text;
            var pass = txtPass.Text;
            if (checkLogin(user, pass))
            {
                File.WriteAllText(PathsData.login, user);
                Process.Start(Application.ResourceAssembly.Location);
                Application.Current.Shutdown();
            }
            else
            {
                MessageBox.Show("Đăng nhập thất bại!");
            }
        }

        private bool checkLogin(string user, string pass)
        {
            XmlDocument doc = new XmlDocument();
            doc.Load(PathsData.accounts);
            var root = doc.DocumentElement;
            var taikhoans = root.GetElementsByTagName("taikhoan");
            for (int i = 0; i < taikhoans.Count; i++)
            {
                var x = taikhoans[i];
                var username = x.Attributes.GetNamedItem("user").Value;
                var password = x.Attributes.GetNamedItem("pass").Value;
                if(username == user && password == pass)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
