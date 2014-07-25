download-and-perform-etl
========================

This is part of my big data analytics project.As part of this project, I am gathering students' reviews, comments and ratings of the schools where they have studied. 
The idea of the project is to collect this kind of user reviews and analyze them in Hadoop.
This program performs the 1st step of the project. It downloads and saves such user reviews from several websites. It downloads webpages, performs ETL (Extraction, Transformation and Loading) of data. The data is saved in XML as well as CSV formats. This is part of my big data analytics project.
The 2nd program fetches data from two more websites: collegeview.com and studentsreview.com.The logic of the program is as follows:
1)	It reads the content of the URL of collegeview.com using InputStreamReader and BufferedReader object and then writes the contents to a temporary HTML file using the BufferedWriter object.
2)	The parameters needed to be extracted from this webpage are stored in a file named Parameters1.txt. The program reads the parameters one by one by using FileInputStream, DataInputStream and BufferedReader objects. Next it extracts that parameter from the temporary HTML file that was created previously. This is done using a method named ‘extractTableData’. The extracted data is stored in a list.
3)	Next, the program gathers data from studentsreview.com. The logic is similar to the one used for collegeview.com earlier. The parameters to be extracted are stored in a file named ‘Parameters3.txt’. The program reads the parameters one by one and then extracts it using a method named extractArraysData. The extracted parameters are stored in the same list as before.
4)	Finally, all the data stored in the list is written in a CSV file. The method ‘createCSV’ takes the parameters list as input and creates the CSV.
