using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C
{
    class Program
    {
        static int CinemasBuildingCost(string[] citiesList, string[] roads)
        {
            int min = 0;
            int tong = 0;
            for (int i = 0; i < citiesList.Length; i++)
            {
                var city = citiesList[i].Split(';')[0];
                var price = Convert.ToInt32(citiesList[i].Split(';')[1]);
                var check = false;
                for (int j = 0; j < roads.Length; j++)
                {
                    if (roads[j].Contains(city) && roads[j] != "!")
                    {
                        check = true;
                        var x = roads[j].Split(';');
                        var temp = x[0] == "city" ? x[1] : x[0];
                        for (int k = 0; k < citiesList.Length; k++)
                        {
                            var p = Convert.ToInt32(citiesList[k].Split(';')[1]);
                            price = price > p ? p : price;
                        }
                        roads[j] = "!";
                    }
                }
                if(check) tong += price;
            }
            return tong;
        }
        static void Main(string[] args)
        {
            string[] citiesList = { "r;209", "c;671", "e;427", "f;980", "l;207" };
            string[] roads = { "r;e", "c;f", "f;l" };
            Console.WriteLine(CinemasBuildingCost(citiesList, roads));
            Console.ReadKey();
        }
    }
}
