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

namespace QLMuonTra
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }
        XmlDocument doc = new XmlDocument();
        XmlElement root;
        private void frmMain_Load(object sender, EventArgs e)
        {
            loadData();
        }

        private void loadData()
        {
            lvMuonTra.Items.Clear();
            doc.Load("danhsachmuontra.xml");
            root = doc.DocumentElement;
            var sinhViens = root.GetElementsByTagName("SinhVien");
            foreach (XmlElement sv in sinhViens)
            {
                var ma = sv.GetAttribute("MaSinhVien");
                var ttSinhVien = sv.FirstChild;
                var ttMuonTra = sv.LastChild;
                var ten = ttSinhVien.FirstChild;
                var lop = ten.NextSibling;
                int sach = 0;
                var muontra = ttMuonTra.ChildNodes;
                for (int i = 0; i < muontra.Count; i++)
                {
                    var sachMuon = muontra[i].LastChild;
                    var sachs = sachMuon.ChildNodes;
                    sach += sachs.Count;
                }

                ListViewItem lvi = new ListViewItem(ma);
                lvi.Tag = ma;
                lvi.SubItems.Add(ten.FirstChild.Value);
                lvi.SubItems.Add(lop.FirstChild.Value);
                lvi.SubItems.Add(muontra.Count+"");
                lvi.SubItems.Add(sach + "");
                lvMuonTra.Items.Add(lvi);
            }
        }

        private void lvMuonTra_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void lvMuonTra_MouseDoubleClick(object sender, MouseEventArgs e)
        {

        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void btnXoa_Click(object sender, EventArgs e)
        {

        }

        private void btnSuaSV_Click(object sender, EventArgs e)
        {

        }

        private void btnThemSV_Click(object sender, EventArgs e)
        {

        }

        private void lvMuonTra_MouseDoubleClick_1(object sender, MouseEventArgs e)
        {
            var lvi = lvMuonTra.SelectedItems[0];
            frmThongTinMuonTra frm = new frmThongTinMuonTra(lvi.Tag.ToString());
            frm.ShowDialog();
            loadData();
        }
    }
}
