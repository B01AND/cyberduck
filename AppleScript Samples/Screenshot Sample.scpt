FasdUAS 1.101.10   ��   ��    k             l     �� ��    = 7  Copyright (c) 2005 Stephen Holt. All rights reserved.       	  l     �� 
��   
 %   http://www.crashonlaunch.org/    	     l     ������  ��        l     �� ��    L F  This program is free software; you can redistribute it and/or modify         l     �� ��    L F  it under the terms of the GNU General Public License as published by         l     �� ��    I C  the Free Software Foundation; either version 2 of the License, or         l     �� ��    + %  (at your option) any later version.         l     ������  ��        l     �� ��    G A  This program is distributed in the hope that it will be useful,         l     ��  ��     F @  but WITHOUT ANY WARRANTY; without even the implied warranty of      ! " ! l     �� #��   # E ?  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the    "  $ % $ l     �� &��   & 4 .  GNU General Public License for more details.    %  ' ( ' l     ������  ��   (  ) * ) l     �� +��   + J D This script is based on code contained in and knowledge gained from    *  , - , l     �� .��   . = 7 Cyberduck's AppleScript Samples - http://cyberduck.ch/    -  / 0 / l     ������  ��   0  1 2 1 l     �� 3��   3 > 8  Bug fixes, suggestions and comments should be sent to:    2  4 5 4 l     �� 6��   6    sholt@crashonlaunch.org    5  7 8 7 l     ������  ��   8  9 : 9 l     �� ;��   ;     Modified by David Kocher    :  < = < l     ������  ��   =  > ? > l     �� @��   @   remote stuff    ?  A B A l     C�� C r      D E D m      F F  example.net    E o      ���� 0 	theserver 	theServer��   B  G H G l    I�� I r     J K J m     L L 	 ftp    K o      ���� 0 theprotocol theProtocol��   H  M N M l    O�� O r     P Q P m    	 R R  username    Q o      ���� 0 theuser theUser��   N  S T S l    U�� U r     V W V m     X X  /images    W o      ���� "0 theremotefolder theRemoteFolder��   T  Y Z Y l     ������  ��   Z  [ \ [ l     �� ]��   ] / ) Set the location for the image and thumb    \  ^ _ ^ l   # `�� ` r    # a b a b     c d c n     e f e 1    ��
�� 
psxp f l    g�� g I   �� h i
�� .earsffdralis        afdr h m    ��
�� afdrdesk i �� j k
�� 
from j m    ��
�� fldmfldu k �� l��
�� 
rtyp l m    ��
�� 
TEXT��  ��   d m     m m  Screenshots    b o      ���� 0 image_location  ��   _  n o n l  $ + p�� p r   $ + q r q o   $ '���� 0 image_location   r o      ���� 0 thumb_location  ��   o  s t s l     ������  ��   t  u v u l     �� w��   w   take the screenshot    v  x y x l  , 3 z�� z I  , 3�� {��
�� .sysodelanull��� ��� nmbr { m   , / | | ?�      ��  ��   y  } ~ } l  4 C ��  I  4 C�� ���
�� .sysoexecTEXT���     TEXT � b   4 ? � � � b   4 ; � � � m   4 7 � �  /usr/sbin/screencapture     � o   7 :���� 0 image_location   � m   ; > � � 
 .pdf   ��  ��   ~  � � � l     ������  ��   �  � � � l     �� ���   �   do the image stuffs    �  � � � l  D � ��� � Q   D � � � � � O   G � � � � k   M � � �  � � � I  M R������
�� .ascrnoop****      � ****��  ��   �  � � � l  S S�� ���   � ' ! get the image from the clipboard    �  � � � r   S b � � � I  S ^�� ���
�� .aevtodocnull  �    alis � b   S Z � � � o   S V���� 0 image_location   � m   V Y � � 
 .png   ��   � o      ���� 0 	the_image   �  � � � l  c c�� ���   �   resize image for thumb    �  � � � I  c p�� � �
�� .icasscalnull��� ��� obj  � o   c f���� 0 	the_image   � �� ���
�� 
maxi � m   i l���� ���   �  � � � l  q q�� ���   �   save the thumb as png    �  � � � I  q ��� � �
�� .coresavenull���    obj  � o   q t���� 0 	the_image   � �� � �
�� 
fltp � m   w z��
�� typvPNGf � �� ���
�� 
kfil � b   } � � � � o   } ����� 0 thumb_location   � m   � � � �  
.thumb.png   ��   �  ��� � I  � ��� ���
�� .coreclosnull���    obj  � o   � ����� 0 	the_image  ��  ��   � m   G J � ��null     ߀��  �Image Events.app �^�     ���p   ��$   )       �,(�]鈿�נ�imev   alis    �  	jungle hd                  ��H+    �Image Events.app                                                 k��d=~        ����  	                CoreServices    ��:      �c�.      �  �  �  6jungle hd:System:Library:CoreServices:Image Events.app  "  I m a g e   E v e n t s . a p p   	 j u n g l e   h d  ,System/Library/CoreServices/Image Events.app  / ��   � R      �� ���
�� .ascrerr ****      � **** � o      ���� 0 error_message  ��   � I  � ��� ���
�� .sysodlogaskr        **** � o   � ����� 0 error_message  ��  ��   �  � � � l     ������  ��   �  � � � l     �� ���   � 1 + upload the image and thumbs with Cyberduck    �  ��� � l  �, ��� � Q   �, � � � � O   � � � � k   � � �  � � � I  � �������
�� .miscactvnull��� ��� null��  ��   �  � � � r   � � � � � l  � � ��� � I  � ��� ���
�� .corecrel****      � null � m   � ���
�� 
docu��  ��   � o      ���� 0 
thebrowser 
theBrowser �  ��� � Q   � � � � � O   � � � � k   � � �  � � � r   � � � � � m   � � � �  UTF-8    � 1   � ���
�� 
enco �  � � � I  � ����� �
�� .CYCKCoCtnull��� ��� obj ��   � �� � �
�� 
HoSt � o   � ����� 0 	theserver 	theServer � �� � �
�� 
PrCl � o   � ����� 0 theprotocol theProtocol � �� � �
�� 
UsMe � o   � ����� 0 theuser theUser � �� ���
�� 
PaTh � o   � ����� "0 theremotefolder theRemoteFolder��   �  � � � I  � ����� �
�� .CYCKUpAdnull��� ��� obj ��   � � ��~
� 
PaTh � b   � � � � � o   � ��}�} 0 image_location   � m   � � � � 
 .png   �~   �  � � � I  ��|�{ �
�| .CYCKUpAdnull��� ��� obj �{   � �z ��y
�z 
PaTh � b   �  � � � o   � ��x�x 0 thumb_location   � m   � � � �  
.thumb.png   �y   �  � � � I 
�w�v�u
�w .CYCKDiCtnull��� ��� obj �v  �u   �  ��t � I �s�r�q
�s .coreclosnull���    obj �r  �q  �t   � l  � � ��p � o   � ��o�o 0 
thebrowser 
theBrowser�p   � R      �n ��m
�n .ascrerr ****      � **** � o      �l�l 0 error_message  �m   � I �k ��j
�k .sysodlogaskr        **** � o  �i�i 0 error_message  �j  ��   � m   � � � ��null     ߀�� U��Cyberduck.app   �����c���     �^��                          CYCK   alis    �  	jungle hd                  ��-#H+   9rCyberduck.app                                                   i(*�g��        ����  	                build     ��      �g��     9r 8�� ?S ?H  I  Ajungle hd:Users:dkocher:Desktop:cyberduck-2.4:build:Cyberduck.app     C y b e r d u c k . a p p   	 j u n g l e   h d  7Users/dkocher/Desktop/cyberduck-2.4/build/Cyberduck.app   /    ��   � R      �h ��g
�h .ascrerr ****      � **** � o      �f�f 0 error_message  �g   � I ',�e ��d
�e .sysodlogaskr        **** � o  '(�c�c 0 error_message  �d  ��  ��       �b � ��b   � �a
�a .aevtoappnull  �   � **** � �` �_�^�]
�` .aevtoappnull  �   � ****  k    ,  A  G  M  S  ^  n		  x

  }  �  ��\�\  �_  �^   �[�[ 0 error_message   : F�Z L�Y R�X X�W�V�U�T�S�R�Q�P�O m�N�M |�L � ��K ��J ��I�H�G�F�E�D�C�B ��A�@�?�>�= ��<�;�:�9 ��8�7�6�5�4�3�2 ��1 ��0�Z 0 	theserver 	theServer�Y 0 theprotocol theProtocol�X 0 theuser theUser�W "0 theremotefolder theRemoteFolder
�V afdrdesk
�U 
from
�T fldmfldu
�S 
rtyp
�R 
TEXT�Q 
�P .earsffdralis        afdr
�O 
psxp�N 0 image_location  �M 0 thumb_location  
�L .sysodelanull��� ��� nmbr
�K .sysoexecTEXT���     TEXT
�J .ascrnoop****      � ****
�I .aevtodocnull  �    alis�H 0 	the_image  
�G 
maxi�F �
�E .icasscalnull��� ��� obj 
�D 
fltp
�C typvPNGf
�B 
kfil
�A .coresavenull���    obj 
�@ .coreclosnull���    obj �? 0 error_message  �>  
�= .sysodlogaskr        ****
�< .miscactvnull��� ��� null
�; 
docu
�: .corecrel****      � null�9 0 
thebrowser 
theBrowser
�8 
enco
�7 
HoSt
�6 
PrCl
�5 
UsMe
�4 
PaTh�3 
�2 .CYCKCoCtnull��� ��� obj 
�1 .CYCKUpAdnull��� ��� obj 
�0 .CYCKDiCtnull��� ��� obj �]-�E�O�E�O�E�O�E�O������ �,a %E` O_ E` Oa j Oa _ %a %j O Oa  E*j O_ a %j E` O_ a a l O_ a  a !a "_ a #%� $O_ j %UW X & '�j (O �a ) x*j *Oa +j ,E` -O Y_ - Oa .*a /,FO*a 0�a 1�a 2�a 3�a 4 5O*a 3_ a 6%l 7O*a 3_ a 8%l 7O*j 9O*j %UW X & '�j (UW X & '�j ( ascr  ��ޭ