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

namespace XMLDOM.GUI
{
    public partial class frmBenhVien : Form
    {
        public frmBenhVien()
        {
            InitializeComponent();
        }
        XmlDocument doc = new XmlDocument();
        XmlElement root, khoaChon;
        int index = 0;
        private void frmBenhVien_Load(object sender, EventArgs e)
        {
            cbKhoa.Items.Clear();
            doc.Load("xml/BenhVien.xml");
            root = doc.DocumentElement;
            var khoas = root.ChildNodes;
            //Load khoa
            for (int i = 0; i < khoas.Count; i++)
            {
                var tenKhoa = khoas[i].Attributes.GetNamedItem("tenkhoa").Value;
                cbKhoa.Items.Add(tenKhoa);
            }
            cbKhoa.SelectedIndex = index;
        }

        private void loadBenhNhan(XmlElement khoa)
        {
            lvBenhNhan.Items.Clear();
            var dsbn = khoa.FirstChild;
            var benhNhans = dsbn.ChildNodes;
            if (benhNhans.Count == 0) return;
            for (int j = 0; j < benhNhans.Count; j++)
            {
                var bn = benhNhans[j];
                var lvi = new ListViewItem(bn.FirstChild.FirstChild.Value);
                lvi.SubItems.Add(bn.Attributes.GetNamedItem("mabenhan").Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(1).FirstChild.Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(2).FirstChild.Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(3).FirstChild.Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(4).FirstChild.Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(5).FirstChild.Value);
                lvi.SubItems.Add(bn.ChildNodes.Item(6).FirstChild.Value);
                lvBenhNhan.Items.Add(lvi);
            }
        }
        private void loadBenhNhan(XmlElement khoa, string tim)
        {
            lvBenhNhan.Items.Clear();
            var dsbn = khoa.FirstChild;
            var benhNhans = dsbn.ChildNodes;
            if (benhNhans.Count == 0) return;
            for (int j = 0; j < benhNhans.Count; j++)
            {
                var bn = benhNhans[j];
                if (tim == bn.Attributes.GetNamedItem("mabenhan").Value)
                {
                    var lvi = new ListViewItem(bn.FirstChild.FirstChild.Value);
                    lvi.SubItems.Add(bn.Attributes.GetNamedItem("mabenhan").Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(1).FirstChild.Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(2).FirstChild.Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(3).FirstChild.Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(4).FirstChild.Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(5).FirstChild.Value);
                    lvi.SubItems.Add(bn.ChildNodes.Item(6).FirstChild.Value);
                    lvBenhNhan.Items.Add(lvi);
                }  
            }
        }
        private void lvBenhNhan_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            loadBenhNhan(khoaChon, txtTim.Text);
        }

        private void cbKhoa_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbKhoa.SelectedIndex == -1)
            {
                return;
            }
            var khoas = root.ChildNodes;
            var chon = cbKhoa.SelectedItem.ToString();
            //Load khoa
            for (int i = 0; i < khoas.Count; i++)
            {
                var tenKhoa = khoas[i].Attributes.GetNamedItem("tenkhoa").Value;
                if (tenKhoa == chon)
                {
                    loadBenhNhan(khoas[i] as XmlElement);
                    khoaChon = khoas[i] as XmlElement;
                    index = cbKhoa.SelectedIndex;
                    break;
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (lvBenhNhan.SelectedIndices.Count <= 0) return;
            var lvi = lvBenhNhan.SelectedItems[0];
            var ma = lvi.SubItems[1].Text;
            var dsbn = khoaChon.FirstChild;
            var benhNhans = dsbn.ChildNodes;
            for (int i = 0; i < benhNhans.Count; i++)
            {
                if (ma == benhNhans[i].Attributes.GetNamedItem("mabenhan").Value)
                {
                    dsbn.RemoveChild(benhNhans[i]);
                    break;
                }
            }
            doc.Save("xml/BenhVien.xml");
            loadData();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            var frm = new frmThemSuaBenhNhan(khoaChon.Attributes.GetNamedItem("tenkhoa").Value.ToString());
            frm.ShowDialog();
            loadData();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (lvBenhNhan.SelectedIndices.Count <= 0) return;
            var frm = new frmThemSuaBenhNhan(khoaChon.Attributes.GetNamedItem("tenkhoa").Value.ToString(),true,
                lvBenhNhan.SelectedItems[0].SubItems[1].Text);
            frm.ShowDialog();
            loadData();
        }

        private void loadData()
        {
            doc.Load("xml/BenhVien.xml");
            root = doc.DocumentElement;
            cbKhoa.SelectedIndex = -1;
            var temp = index;
            cbKhoa.SelectedIndex = temp;
            loadBenhNhan(khoaChon);
        }
    }
}
