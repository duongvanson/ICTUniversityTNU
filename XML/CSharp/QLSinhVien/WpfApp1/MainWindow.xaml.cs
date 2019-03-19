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

namespace WpfApp1
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
        private void addItem(string text)
        {
            TextBlock block = new TextBlock();

            // Add the text   
            block.Text = text;

            // A little style...   
            block.Margin = new Thickness(2, 3, 2, 3);
            block.Cursor = Cursors.Hand;

            // Mouse events   
            block.MouseLeftButtonUp += (sender, e) =>
            {
                textBox.Text = (sender as TextBlock).Text;
                popup.IsOpen = false;
            };

            block.MouseEnter += (sender, e) =>
            {
                TextBlock b = sender as TextBlock;
                b.Background = Brushes.PeachPuff;
            };

            block.MouseLeave += (sender, e) =>
            {
                TextBlock b = sender as TextBlock;
                b.Background = Brushes.Transparent;
            };

            // Add to the panel   
            resultStack.Children.Add(block);
        }
        static public List<string> GetData()
        {
            List<string> data = new List<string>();

            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Afzaal");
            data.Add("Ahmad");
            data.Add("Zeeshan");
            data.Add("Daniyal");
            data.Add("Rizwan");
            data.Add("John");
            data.Add("Doe");
            data.Add("Johanna Doe");
            data.Add("Pakistan");
            data.Add("Microsoft");
            data.Add("Programming");
            data.Add("Visual Studio");
            data.Add("Sofiya");
            data.Add("Rihanna");
            data.Add("Eminem");

            return data;
        }
        private void TextBox_KeyUp(object sender, KeyEventArgs e)
        {
            popup.IsOpen = true;
            //helloborder.Visibility = Visibility.Visible;
            bool found = false;
            //var border = (resultStack.Parent as ScrollViewer).Parent as Border;
            var data = MainWindow.GetData();

            string query = (sender as TextBox).Text;

            if (query.Length == 0)
            {
                // Clear   
                resultStack.Children.Clear();
                popup.Visibility = System.Windows.Visibility.Collapsed;
            }
            else
            {
                popup.Visibility = System.Windows.Visibility.Visible;
            }

            // Clear the list   
            resultStack.Children.Clear();

            // Add the result   
            foreach (var obj in data)
            {
                if (obj.ToLower().StartsWith(query.ToLower()))
                {
                    // The word starts with this... Autocomplete must work   
                    addItem(obj);
                    found = true;
                }
            }

            if (!found)
            {
                resultStack.Children.Add(new TextBlock() { Text = "No results found." });
            }
        }
    }
}
