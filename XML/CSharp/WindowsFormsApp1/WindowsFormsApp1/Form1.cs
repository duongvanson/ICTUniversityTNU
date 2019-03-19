using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        XmlDocument document = new XmlDocument();
        private void Form1_Load(object sender, EventArgs e)
        {
            richTextBox1.ResetText();
            document.Load("books.xml");
            var root = document.DocumentElement;
            var books = root.ChildNodes;
            foreach (XmlElement book in books)
            {
                var child = book.ChildNodes;
                foreach (XmlElement data in child)
                {
                    if (book.Attributes.GetNamedItem("category").Value == "cooking")
                    {
                        if (data.Name == "price")
                        {
                            //data.FirstChild.Value = double.Parse(data.FirstChild.Value) + 10+"";
                        }
                    }
                    richTextBox1.Text += data.FirstChild.Value+"\n";
                }
                richTextBox1.Text += "========\n";
            }
            document.Save("books.xml");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            document.Load("books.xml");
            var root = document.DocumentElement;
            var books = root.ChildNodes;
            books.Item(0).ChildNodes.Item(2).FirstChild.Value = "2019";
            document.Save("books.xml");
            this.OnLoad(e);
        }
    }
}
