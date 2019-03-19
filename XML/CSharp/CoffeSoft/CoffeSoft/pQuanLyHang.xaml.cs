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

namespace CoffeSoft
{
    /// <summary>
    /// Interaction logic for pQuanLyHang.xaml
    /// </summary>
    public partial class pQuanLyHang : Page
    {
        public pQuanLyHang()
        {
            InitializeComponent();
        }

        private void BtnThem_Click(object sender, RoutedEventArgs e)
        {
            wThemSuaHang w = new wThemSuaHang();
            w.ShowDialog();
        }
    }
}
