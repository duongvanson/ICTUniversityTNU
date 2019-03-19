using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Xml;
namespace CoffeSoft
{
    public class PathsData
    {
        public static String baseFolder = Environment.GetFolderPath(Environment.SpecialFolder.CommonApplicationData);
        public static String folder = Path.Combine(baseFolder, "CoffeSoft");
        public static String accounts = Path.Combine(folder, "account.xml");
        public static String products = Path.Combine(folder, "products.xml");
        public static String login = Path.Combine(folder, "login.bin");
        public static String setup = Path.Combine(folder, "setup.bin");

        public static void createdPaths(String username, string password, string fullName)
        {
            if (!Directory.Exists(folder))
            {
                Directory.CreateDirectory(folder);
                var acc = File.Create(accounts);
                var pro = File.Create(products);
                var log = File.Create(login);
                var set = File.Create(setup);
                XmlDocument docAcc = new XmlDocument();
                var root = docAcc.CreateElement("taikhoans");
                var taikhoan = docAcc.CreateElement("taikhoan");
                var user = docAcc.CreateAttribute("user");
                user.Value =username;
                var pass = docAcc.CreateAttribute("pass");
                pass.Value = password;
                var chucvu = docAcc.CreateAttribute("chucvu");
                chucvu.Value = "quanly";
                var ten = docAcc.CreateElement("hoten");
                ten.AppendChild(docAcc.CreateTextNode(fullName));
                taikhoan.Attributes.Append(user);
                taikhoan.Attributes.Append(pass);
                taikhoan.Attributes.Append(chucvu);
                taikhoan.AppendChild(ten);
                root.AppendChild(taikhoan);
                docAcc.AppendChild(root);
                docAcc.Save(acc);

                XmlDocument docPro = new XmlDocument();
                var rootPro = docPro.CreateElement("products");
                docPro.AppendChild(rootPro);
                docPro.Save(pro);
                acc.Close();
                pro.Close();
                log.Close();
                set.Close();
                File.WriteAllText(login, "false");
                File.WriteAllText(setup, "true");
            }
        }
    }
}
