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
using System.Windows.Shapes;
using System.Xml;

namespace CoffeSoft
{
    /// <summary>
    /// Interaction logic for wThemSuaHang.xaml
    /// </summary>
    public partial class wThemSuaHang : Window
    {
        public wThemSuaHang()
        {
            InitializeComponent();
        }

        private void BtnXacNhan_Click(object sender, RoutedEventArgs e)
        {
            var ma = txtMa.Text;
            var ten = txtTen.Text;
            var gia = txtGia.Text;

            XmlDocument doc = new XmlDocument();
            doc.Load(PathsData.products);
            var root = doc.DocumentElement;
            var hang = doc.CreateElement("product");
            hang.SetAttribute("ma", ma);
            var tenhang = doc.CreateElement("tenhang");
            tenhang.AppendChild(doc.CreateTextNode(ten));
            var dongia = doc.CreateElement("dongia");
            dongia.AppendChild(doc.CreateTextNode(gia));

            hang.AppendChild(tenhang);
            hang.AppendChild(dongia);
            root.AppendChild(hang);
            doc.Save(PathsData.products);
            MessageBox.Show("Thêm thành công!");
            this.Close();
        }
    }
}
