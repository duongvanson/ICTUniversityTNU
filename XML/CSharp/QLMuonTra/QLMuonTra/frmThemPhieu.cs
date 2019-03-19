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
    public partial class frmThemPhieu : Form
    {
        public frmThemPhieu()
        {
            InitializeComponent();
        }
        XmlDocument doc = new XmlDocument();
        XmlElement root, sv;
        public frmThemPhieu(XmlElement root, XmlElement sv)
        {
            InitializeComponent();
            this.root = root;
            this.sv = sv;
        }
        private void btnXacNhan_Click(object sender, EventArgs e)
        {
            var muonTra = doc.CreateElement("MuonTra");

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void frmThemPhieu_Load(object sender, EventArgs e)
        {
            dateMuon.Value = DateTime.Now;
            doc.Load("danhsachmuontra.xml");
        }
    }
}
