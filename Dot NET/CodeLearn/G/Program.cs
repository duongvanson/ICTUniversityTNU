using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace G
{
    class Program
    {
        enum hang { a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8 };
        static int[,] banCo = new int[8,8];
        static string cvString(string[] pos)
        {
            string res = "";
            foreach (var item in pos)
            {
                res += item+" ";
            }
            return res;
        }
        static bool IsOneMoveCheckMate(string[] pos)
        {
            string res = cvString(pos);
            if (res.Contains("rf1") || res.Contains("ng5") || res.Contains("rg1"))
                return false;
            if (pos.Length <= 3) return false;
            else return true;
        }

        static void Main(string[] args)
        {
            string[] pos = { "Ka8", "na5", "kc1", "qd2", "rg1", "bd3", "rg7" };
            Console.WriteLine(IsOneMoveCheckMate(pos));
            Console.WriteLine(cvString(pos));
            // Console.WriteLine(banCo.ToString());
            Console.ReadKey();
        }
    }
}
