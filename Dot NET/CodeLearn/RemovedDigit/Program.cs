using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RemovedDigit
{
    class Program
    {
        static int RemovedDigit(int n, int[] s, int k)
        {
            String inp = "";
            for (int i = 1; i <= n; i++)
            {
                inp += i + "";
            }
            int outp = -1;
            int run = 0;
            int temp = k;
            while (k != 0)
            {
                if (run >= inp.Length-1) return -1;
                for (int i = run; i < inp.Length; i++)
                {
                    bool check = false;
                    for (int j = 0; j < s.Length; j++)
                    {
                        if (int.Parse(inp[i]+"") == s[j])
                        {
                            outp = int.Parse(inp[i] + "");
                            check = true;
                            break;
                        }
                    }
                    if(check)
                    {
                        run = i + 1;
                        k--;
                        break;
                    }
                    if (i == inp.Length-1 && k >= 1)
                    {
                        return -1;
                    }
                }
            }
            return outp;
        }

        static void Main(string[] args)
        {
            //12 34 56 78 9101112 1314 15
            //
            int[] x = {2,3};
            Console.WriteLine(RemovedDigit(4, x, 3));
            Console.ReadKey();
        }
    }
}
