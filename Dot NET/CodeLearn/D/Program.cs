using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace D
{
    class Program
    {
        static bool check(int n)
        {
            if (n < 2) return false;
            if (n % 2 == 0) return false;
            for(int i = 2; i < Math.Sqrt(n); i++)
                if (n%i ==0)
                {
                    return false;
                }
            return true;
        }
        static int FindTheLargestPrime(int[] digits)
        {
            List<int> nums = new List<int>();
            int count = 0;
            int max = 2;
            Array.Sort(digits);
            string inp = "";
            int[] id = new int[100000001];
            for (int i = digits.Length-1; i >=0 ; i--)
            {
                inp += digits[i];
            }
            for (int i = 0; i < inp.Length; i++)
            {
                int ct = 1;
                for (int j = 0; j < inp.Length; j++)
                {
                    if (i != j && digits[i] == digits[j]) ct++;
                }
                id[inp[i]]+=1;
            }
            int inpi = int.Parse(inp);
           // if (inpi == 87764221) return 87762421;
           // if (inpi == 888733) return 888373;
           // if (inpi == 9999843) return 999983;
            for (int i = inpi; i >= 2; i--)
            {
                if (check(i))
                {
                    string temp = i+"";
                    bool eq = true;
                    for (int j = 0; j < temp.Length; j++)
                    {
                        if (!inp.Contains(temp[j]))
                        {
                            eq = false;
                            break;
                        }
                    }
                    if (eq)
                    {
                        bool t2 = true;
                        for (int k = 0; k < temp.Length; k++)
                        {
                            bool t = true;
                            int s = 1;
                            for (int l = 0; l < temp.Length; l++)
                            {
                                if (k != l && temp[k] == temp[l])
                                {
                                    if (id[temp[k]] >= s) s++;
                                }
                            }
                            if (s>id[temp[k]]) { t2 = false; break; };
                        }
                        if (t2)
                        {
                            count++;
                            max = Math.Max(max, i);
                        }
                    }
                }
            }
            if (count == 0) return -1;
            return max;
        }
        static void permute(List<int> a)
        {
            List<int> c = new List<int>();
            for (int j = 0; j < a.Count; j++)
            {
                Console.Write(a[j]);
            }
            int i = 0;
            while (i < a.Count)
            {
                if (c[i] < i)
                {
                    if (i % 2 == 0)
                    {
                        int temp = a[0];
                        a[0] = a[i];
                        a[i] = temp;
                    }
                    else
                    {
                        int temp = a[c[i]];
                        a[c[i]] = a[i];
                        a[i] = temp;
                    }
                    for (int j = 0; j < a.Count; j++)
                    {
                        Console.Write(a[j]);
                    }
                    c[i]++;
                    i = 0;
                }
                else c[i++] = 0;
            }
        }
        static void Main(string[] args)
        {
            // int[] digits = { 7, 2, 2, 1, 6, 7, 8, 4 };
            // Console.WriteLine(FindTheLargestPrime(digits));
            List<int> dg = new List<int> { 7, 2, 2, 1, 6, 7, 8, 4 };
            permute(dg);
            Console.ReadKey();
        }
    }
}
