using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace QLSinhVien
{
    public partial class frmThemVaSua : Form
    {
        public frmThemVaSua()
        {
            InitializeComponent();
        }
        XmlDocument doc;
        XmlNode sinhvien, ma, ten, lop;
        String file;
        bool b = true;
        int index;
        public frmThemVaSua(XmlDocument doc, string file)
        {
            InitializeComponent();
            this.doc = doc;
            this.file = file;
        }
        public frmThemVaSua(XmlDocument doc, string file, int index)
        {
            InitializeComponent();
            this.doc = doc;
            this.file = file;
            this.b = false;
            this.index = index;
        }
        private void frmThemVaSua_Load(object sender, EventArgs e)
        {
            if (!b)
            {
                btnThem.Text = "Cập nhật";
                var root = doc.DocumentElement;
                sinhvien = root.ChildNodes.Item(index);
                ma = sinhvien.FirstChild;
                ten = ma.NextSibling;
                lop = ten.NextSibling;
                txtMa.Text = ma.FirstChild.Value;
                txtTen.Text = ten.FirstChild.Value;
                txtLop.Text = lop.FirstChild.Value;
            }
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            if (b)
            {
                var root = doc.DocumentElement;
                var sinhvien = doc.CreateElement("sinhvien");
                var ma = doc.CreateElement("masinhvien");
                ma.InnerText = txtMa.Text;
                var ten = doc.CreateElement("tensinhvien");
                ten.InnerText = txtTen.Text;
                var lop = doc.CreateElement("lop");
                lop.InnerText = txtLop.Text;

                sinhvien.AppendChild(ma);
                sinhvien.AppendChild(ten);
                sinhvien.AppendChild(lop);
                root.AppendChild(sinhvien);
            }
            else
            {
                ma.FirstChild.Value = txtMa.Text;
                ten.FirstChild.Value = txtTen.Text;
                lop.FirstChild.Value = txtLop.Text;
            }
            doc.Save(file);
            this.Close();
        }
    }
}
