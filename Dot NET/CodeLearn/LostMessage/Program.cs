using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LostMessage
{
    class Program
    {
        static string LostMessage(string[] message)
        {
            List<String> R = new List<string>();
            for (int i = 0; i < message.Length; i++)
            {
                if (message[i].Substring(0, 1) == "R")
                {
                    var arr = message[i].Split(':');
                    R.Add(arr[1]);
                    message[i] = "XXX";
                }
            }
            for (int i = 0; i < R.Count; i++)
            {
                for (int j = 0; j < message.Length; j++)
                {
                    if (message[j] != "XXX")
                    {
                        char[] arr = R[i].ToCharArray();
                        Array.Reverse(arr);
                        string iR = new string(arr);
                        var am = message[j].Split(':');
                       //Console.WriteLine("{0} <> {1}", iR, am[1]);
                        if (iR == am[1])
                        {
                            message[j] = "XXX";
                        }
                    }
                }
            }
            string outp = "";
            foreach (var item in message)
            {
                if (item != "XXX")
                {
                    outp =  item;
                }
            }
            return outp.Substring(2);
        }

        static void Main(string[] args)
        {
            string[] str = {"S:zsncf5314198IZOFI","R:IFOZI8914135fcnsz","S:zszjo5857391DWTUC","R:CUTWD1937585ojzsz","S:xiidj2356366MMFHW","R:WHFMM6636532jdiix","S:ekprc3898874TNIXT","R:TXINT4788983crpke","S:lmekh3048939FUQRI","R:IRQUF9398403hkeml","S:bfamh3815909XYJSN","R:NSJYX9095183hmafb","S:lrlwf732281DVSFE","R:EFSVD182237fwlrl","S:djbdd9505876JJXGL","R:LGXJJ6785059ddbjd","S:eztkx5976243EYEBM","R:MBEYE3426795xktze","S:oiknf3721519CPEUG","R:GUEPC9151273fnkio","S:vfomj3540390OTSOR","R:ROSTO0930453jmofv","S:utamm2915264HRMBG","R:GBMRH4625192mmatu","S:mlxmh6546043HHAEU","R:UEAHH3406456hmxlm","S:swiya8475751NXIOD","R:DOIXN1575748ayiws","S:apzbl5041188WDEAZ","R:ZAEDW8811405lbzpa","S:xqnih9555848TJOAW","R:WAOJT8485559hinqx","S:rkoac5421667JTACC","R:CCATJ7661245caokr","S:aujhi421538WDYHM","R:MHYDW835124ihjua","S:ikmbo5898298HUPFM","R:MFPUH8928985obmki","S:skkod5177433SXVXZ","R:ZXVXS3347715dokks","S:HaveFunWithCodeLearn"};
            string[] str2 = { "S:ab", "S:bc", "R:ba" };
            Console.WriteLine(LostMessage(str));
            Console.ReadKey();
        }
    }
}
