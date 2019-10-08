using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace B
{
    class Program
    {
        static long NonOverlappingArea(int[] a, int[] b)
        {
            long d1 = a[2] - a[0];
            long d2 = a[3] - a[1];
            long x1 = b[2] - b[0];
            long x2 = b[3] - b[1];
            long t1=0, t2=0;
            if(a == b)
            {
                return 0;
            }
            else if(b[2] == a[0])
            {
                return d1 * d2 + x1 * x2;
            }
            else if(b[3] < a[3])
            {
                int[] p1 = { b[3], b[2] - a[2] };
                int[] p2 = { b[0], b[1] - a[1] };
                t1 = p1[1] - p2[0];
                t2 = p1[0] - p2[1];
            }
            else
            {
                t1 = a[2] - b[0];
                t2 = a[3] - b[1];
            }
            return t1*t2>0? d1*d2+x1*x2-t1*t2*2 : d1 * d2 + x1 * x2;
        }
        static long NonOverlappingArea2(int[] a, int[] b)
        {
            long d1 = a[2] - a[0];
            long d2 = a[3] - a[1];
            long x1 = b[2] - b[0];
            long x2 = b[3] - b[1];
            long t1 = 0, t2 = 0;
            t1 = a[2] - b[0];
            t2 = a[3] - b[1];
            return d1 * d2 + x1 * x2 - t1 * t2 * 2;
        }
        static void Main(string[] args)
        {
            int[] a = { -2, -1, 3, 3 };
            int[] b = { 4, -2, 6, 2 };
            Console.WriteLine(NonOverlappingArea2(a,b));
            Console.ReadKey();
        }
        //[-2,  -1,     3,  3], [       2,      -2,     6,      2]
        //[-238,3488, 328, 999998], [-999999, 927538, -2347, 8698239]
    }
}
