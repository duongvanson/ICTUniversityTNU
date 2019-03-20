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
    public partial class frmThemSuaBenhNhan : Form
    {
        public frmThemSuaBenhNhan()
        {
            InitializeComponent();
        }
        string khoa;
        XmlDocument doc = new XmlDocument();
        XmlElement root;
        bool task = false;
        string mabenhan;
        public frmThemSuaBenhNhan(String khoa)
        {
            InitializeComponent();
            this.khoa = khoa;
        }
        public frmThemSuaBenhNhan(String khoa, bool task, string mabenhan)
        {
            InitializeComponent();
            this.khoa = khoa;
            this.task = task;
            this.mabenhan = mabenhan;
        }
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void frmThemSuaBenhNhan_Load(object sender, EventArgs e)
        {
            doc.Load("xml/BenhVien.xml");
            root = doc.DocumentElement;
            if (task)
            {
                var khoas = root.ChildNodes;
                for (int i = 0; i < khoas.Count; i++)
                {
                    var tenKhoa = khoas[i].Attributes.GetNamedItem("tenkhoa").Value;
                    if (tenKhoa == khoa)
                    {
                        var dsbn = khoas[i].FirstChild;
                        var benhNhans = dsbn.ChildNodes;
                        for (int j = 0; j < benhNhans.Count; j++)
                        {
                            var bn = benhNhans[j];
                            if (mabenhan == bn.Attributes.GetNamedItem("mabenhan").Value)
                            {
                                txtMa.Text = bn.Attributes.GetNamedItem("mabenhan").Value;
                                txtTen.Text = bn.ChildNodes.Item(1).FirstChild.Value;
                                txtDiaChi.Text = bn.ChildNodes.Item(2).FirstChild.Value;
                                txtGioiTinh.Text = bn.ChildNodes.Item(3).FirstChild.Value;
                                dateNhap.Value = DateTime.Parse(bn.ChildNodes.Item(4).FirstChild.Value);
                                txtNgay.Text = bn.ChildNodes.Item(5).FirstChild.Value;
                                txtTien.Text = bn.ChildNodes.Item(6).FirstChild.Value;
                                break;
                            }
                        }
                    }
                }
            }
        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            if (task)
            {
                var khoas = root.ChildNodes;
                for (int i = 0; i < khoas.Count; i++)
                {
                    var tenKhoa = khoas[i].Attributes.GetNamedItem("tenkhoa").Value;
                    if (tenKhoa == khoa)
                    {
                        var dsbn = khoas[i].FirstChild;
                        var benhNhans = dsbn.ChildNodes;
                        for (int j = 0; j < benhNhans.Count; j++)
                        {
                            var bn = benhNhans[j];
                            if (mabenhan == bn.Attributes.GetNamedItem("mabenhan").Value)
                            {
                                bn.Attributes.GetNamedItem("mabenhan").Value = txtMa.Text;
                                bn.ChildNodes.Item(1).FirstChild.Value = txtTen.Text;
                                bn.ChildNodes.Item(2).FirstChild.Value = txtDiaChi.Text;
                                bn.ChildNodes.Item(3).FirstChild.Value = txtGioiTinh.Text;
                                bn.ChildNodes.Item(4).FirstChild.Value = dateNhap.Value.ToShortDateString();
                                bn.ChildNodes.Item(5).FirstChild.Value = txtNgay.Text;
                                bn.ChildNodes.Item(6).FirstChild.Value = txtTien.Text;
                                break;
                            }
                        }
                    }
                }
            }
            else
            {
                var khoas = root.ChildNodes;
                for (int i = 0; i < khoas.Count; i++)
                {
                    var tenKhoa = khoas[i].Attributes.GetNamedItem("tenkhoa").Value;
                    if (tenKhoa == khoa)
                    {
                        var dsbn = khoas[i].FirstChild;
                        var stt = dsbn.ChildNodes.Count + 1;
                        var benhNhan = doc.CreateElement("BenhNhan");
                        benhNhan.SetAttribute("mabenhan", txtMa.Text);
                        var stt2 = doc.CreateElement("STT");
                        stt2.AppendChild(doc.CreateTextNode(stt + ""));
                        benhNhan.AppendChild(stt2);
                        var hoTen = doc.CreateElement("HoTen");
                        hoTen.AppendChild(doc.CreateTextNode(txtTen.Text + ""));
                        benhNhan.AppendChild(hoTen);
                        var diaChi = doc.CreateElement("DiaChi");
                        diaChi.AppendChild(doc.CreateTextNode(txtDiaChi.Text + ""));
                        benhNhan.AppendChild(diaChi);
                        var gioiTinh = doc.CreateElement("GioiTinh");
                        gioiTinh.AppendChild(doc.CreateTextNode(txtGioiTinh.Text + ""));
                        benhNhan.AppendChild(gioiTinh);
                        var ngay = doc.CreateElement("NgayNhap");
                        ngay.AppendChild(doc.CreateTextNode(dateNhap.Value.ToShortDateString() + ""));
                        benhNhan.AppendChild(ngay);
                        var ngayDT = doc.CreateElement("SoNgay");
                        ngayDT.AppendChild(doc.CreateTextNode(txtNgay.Text + ""));
                        benhNhan.AppendChild(ngayDT);
                        var tien = doc.CreateElement("TienTra");
                        tien.AppendChild(doc.CreateTextNode(txtTien.Text + ""));
                        benhNhan.AppendChild(tien);
                        dsbn.AppendChild(benhNhan);
                        break;
                    }
                }
            }
            doc.Save("xml/BenhVien.xml");
            this.Close();
        }
    }
}
