   M S B A M L   `   `   `  ����D  @CoffeSoft, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:CoffeSoft	CoffeSoft  5   	       CoffeSoft.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:CoffeSoft     5   	   -   5          � Title$  
MainWindow��5	   	   $	��600��6   $	��800��6)    � 	Resources 5
       �� 
TargetType   lblMenu �� Property �� Value  imgMenu  Menu��%j  &	        &	 n     &	     �� 5   
   " ��6   .�5      ��  � ��$ 16(�6)   �� 5       � ��$
 10 0q�6'   5      �� 5   
   " ��6   .�5      ��  � ��$
 10 0q�6'   �� 5       � ��$ 26��6&   �� 5       � ��$
 auto��6'   5      �� 5   
   " ��6   .�5      ��  � ��$
 0 14q�6(   5      5      .��5      � -   5        $��gvMain��5       � ColumnDefinitions 5   
   �� 5      $��3* �6   �� 5      $��7* �6   .+�5   
   �� -   5        $��mnuSide��5      ���#1abc9c$��1q�5      $��0��5       ._�5!      �� .+�5"      �� $	��150��6   ���#1abc9c.+�5$      �� $��image/account52.png��6   $��80��5%      $
��0 10q�5&      �� 5'      -   5         ��Name$ tbChucVu��5'       $��Admin��5(      $��Center=�5)      $��16(�5*      ���#fff$��5q�5,      �� 5-      -   5        $ tbName��5-       $��Dương Văn Sơn��5.      $��Center=�5/      $��16(�50      ���#fff51      52      �� 53      -   5         ��Name$ lboxMenu��53       � Cursor$
 Hand��54      $��0q�55      .@�59      �� 
	 � Tag$	 banhang��6"   #��[ 5:      .��5;      �� 
 �� Orientation$
 
Horizontal=�6%   .+�5<      �� $"��images/icons8-receipt-48.png��6$   #��[ 5=       �� 5>      $��
Bán hàng��6$   #��[  5?       5@      5A      �� 5B      $	 
quanlyhang��6"   #��[ 5C      .��5D      �� $
 
Horizontal=�6%   .+�5E      �� $��images/icons8-box-52.png��6$   #��[ 5F       �� 5G      $��Quản lý hàng��6$   #��[  5H       5I      5J      �� 5K      $	 quanlynhanvien��6"   #��[ 5L      .��5M      �� $
 
Horizontal=�6%   .+�5N      �� $��images/account52.png��6$   #��[ 5O       �� 5P      $��Quản lý nhân viên��6$   #��[  5Q       5R      5S      �� 5T      -   5         ��Name$ 	btnLogout��5U   "   $	 logout��5T   "   #��[ 5V      .��5W      �� $
 
Horizontal=�6%   .+�5X      �� $��images/icons8-exit-52.png��6$   #��[ 5Y       �� 5Z      $��Đăng xuất��6$   #��[  5[       5\      5]      5^      5_      5`       � 5a   
   -   5          �Name$ viewMain��5c      $��1��5a      $��Stretch=�5b        � JournalOwnership$ UsesParentJournal=�5d      5e      5g      5h      