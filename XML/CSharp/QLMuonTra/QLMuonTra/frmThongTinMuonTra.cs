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
    public partial class frmThongTinMuonTra : Form
    {
        public frmThongTinMuonTra()
        {
            InitializeComponent();
        }
        string ma;
        XmlDocument doc = new XmlDocument();
        XmlElement root;
        XmlElement sinhvien;
        public frmThongTinMuonTra(String ma)
        {
            InitializeComponent();
            this.ma = ma;
        }
        private void frmThongTinMuonTra_Load(object sender, EventArgs e)
        {
            loadData();
        }

        private void loadData()
        {
            lbPhieu.DisplayMember = "Tag";
            doc.Load("danhsachmuontra.xml");
            var sinhviens = doc.GetElementsByTagName("SinhVien");
            for (int i = 0; i < sinhviens.Count; i++)
            {
                var sv = sinhviens[i];
                var ma = sv.Attributes.GetNamedItem("MaSinhVien").Value;
                if (ma == this.ma)
                {
                    sinhvien = sv as XmlElement;
                    this.Text = sv.FirstChild.FirstChild.FirstChild.Value.ToString();
                    var ttMuonTra = sv.LastChild;
                    var phieus = ttMuonTra.ChildNodes;
                    for (int j = 0; j < phieus.Count; j++)
                    {
                        var x = phieus[i].FirstChild.FirstChild.Value.ToString();
                        var item = new ListViewItem("Phiếu mượn ngày " + x);
                        item.Tag = x;
                        lbPhieu.Items.Add(item);
                    }
                    return;
                }
            }
        }

        private void lbPhieu_SelectedIndexChanged(object sender, EventArgs e)
        {
            lstSach.Items.Clear();
            var item =(ListViewItem) lbPhieu.SelectedItem;
            //MessageBox.Show(item.ToString());
            var muontras = sinhvien.GetElementsByTagName("MuonTra");
            for (int i = 0; i < muontras.Count; i++)
            {
                var mt = muontras[i];
                if (mt.FirstChild.FirstChild.Value == item.Tag.ToString())
                {
                    var muon = mt.LastChild;
                    var sachs = muon.ChildNodes;
                    for (int j = 0; j < sachs.Count; j++)
                    {
                        var s = sachs[i];
                        var lvi = new ListViewItem(s.Attributes.GetNamedItem("MaSach").Value);
                        lvi.SubItems.Add(s.ChildNodes.Item(0).FirstChild.Value);
                        lvi.SubItems.Add(s.ChildNodes.Item(1).FirstChild.Value);
                        lvi.SubItems.Add(s.ChildNodes.Item(2).FirstChild.Value);
                        lstSach.Items.Add(lvi);
                    }
                }
            }
        }

        private void xóaPhiếuToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void thêmPhiếuToolStripMenuItem_Click(object sender, EventArgs e)
        {
            var frm = new frmThemPhieu(root, sinhvien);
            frm.ShowDialog();
            loadData();
        }
    }
}
