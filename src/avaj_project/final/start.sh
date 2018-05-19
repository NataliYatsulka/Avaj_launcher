find . -name *.java > sources.txt
javac -sourcepath @sources.txt
java avaj_project.com.company.Main ./avaj_project/com/company/scenario.txt
