<h1 align="center">Japanase Role Playing Game (JRPG)</h1>
<h3 align="center">OOP LG01 - Assignment</h3>

<br>

## A. ANGGOTA KELOMPOK
<ol>
	<li>Anderson Pieter - 2440029574</li>
	<li>Maverick Sean Therry - 2440079471</li>
	<li>Muhamad Ndaru Hestiafin - 2440064766</li>
	<li>Yosua Gunawan - 2440030292</li>
</ol>

<br>

## B. PENJELASAN KASUS
<p>Kasus yang kita buat adalah adalah game sederhana tentang JRPG (Japanase Role Playing Game) dimana kita memiliki 2 karakter, yaitu Knight dan Wizard. Knight dan Wizard akan saling menyerang (Attack) hingga salah satu mati (Die).</p>

<p>Dalam mengimplementasikan kelas abstrak, kita membuat Stamina, BleedDamage, dan ShieldDefense pada Knight yang juga memiliki method Defend(). Pada Wizard terdapat Mana dan method Heal().</p>

<br>

## C. CLASS ANALYSIS
<p>Terdapat 3 class yang terdiri dari 1 abstract class yaitu Character yang merupakan parent dari 2 class child, relationship Knight dan Wizard adalah inheritance dari Character. Attribute-attribute yang diinheritkan adalah Name, Health, Defense, Damage, Level, dan Exp. Terdapat 5 abstract method yang menjadi blueprint bagi Knight dan Wizard, 5 abstract method tersebut adalah Die, Attack, TakeDamage, GenerateStats, dan LevelUp. 
Untuk 4 method lain merupakan method biasa yang langsung diinheritkan kepada Knight dan Wizard. 
</p>

<p>Knight sendiri memiliki attribute Stamina, BleedDamage, dan ShieldDefense, dimana ketika menggunakan method Defend, total Damage yang akan diterima akan dikurangi oleh ShieldDefense. Sedangkan Wizard memiliki attribute Mana yang dimana ketika Wizard Heal, Mana akan berkurang tetapi menambah Health Wizard.</p>

<br>

## D. CLASS DIAGRAM
<img src="https://snipboard.io/8TDP9x.jpg" width="100%"> <br>