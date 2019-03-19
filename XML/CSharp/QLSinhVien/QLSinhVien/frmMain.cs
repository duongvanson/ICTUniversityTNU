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
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }
        string file = @"data/danhsachsinhvien.xml";
        XmlDocument doc = new XmlDocument();
        XmlElement root;
        private void frmMain_Load(object sender, EventArgs e)
        {
            loadData();
        }

        private void loadData()
        {
            lvSinhVien.Items.Clear();
            doc.Load(file);
            root = doc.DocumentElement;
            var sinhviens = root.ChildNodes;
            foreach (XmlElement sinhvien in sinhviens)
            {
                var ma = sinhvien.FirstChild;
                var ten = ma.NextSibling;
                var lop = ten.NextSibling;
                ListViewItem lvi = new ListViewItem(ma.FirstChild.Value);
                lvi.SubItems.Add(ten.FirstChild.Value);
                lvi.SubItems.Add(lop.FirstChild.Value);
                lvSinhVien.Items.Add(lvi);
            }
        }
        private void btnThem_Click(object sender, EventArgs e)
        {
            frmThemVaSua frm = new frmThemVaSua(doc, file);
            frm.ShowDialog();
            loadData();
        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            if (lvSinhVien.SelectedIndices.Count == 0)
            {
                MessageBox.Show("Chưa chọn sinh viên");
                return;
            }
            frmThemVaSua frm = new frmThemVaSua(doc, file, lvSinhVien.SelectedIndices[0]);
            frm.ShowDialog();
            loadData();
        }

        private void lvSinhVien_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            if (lvSinhVien.SelectedIndices.Count == 0)
            {
                MessageBox.Show("Chưa chọn sinh viên");
                return;
            }
            var rs = MessageBox.Show("Xác nhận xóa?", "Xóa", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
            if (rs == DialogResult.OK)
            {
                var sinhvien = root.ChildNodes.Item(lvSinhVien.SelectedIndices[0]);
                root.RemoveChild(sinhvien);
                doc.Save(file);
                loadData();
            }
        }
    }
}
