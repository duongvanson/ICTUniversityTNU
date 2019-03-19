using System;
using System.Collections.Generic;
using System.Diagnostics;
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
    /// Interaction logic for pSetup.xaml
    /// </summary>
    public partial class pSetup : Page
    {
        public pSetup()
        {
            InitializeComponent();
        }

        private void BtnXacNhan_Click(object sender, RoutedEventArgs e)
        {
            var user = txtAdmin.Text;
            var pass = txtPass.Text;
            var name = txtFullName.Text;

            PathsData.createdPaths(user, pass, name);

            Process.Start(Application.ResourceAssembly.Location);
            Application.Current.Shutdown();
        }
    }
}
