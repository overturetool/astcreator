@echo off
REM http://cemerick.com/2010/08/24/hosting-maven-repos-on-github/
cd target
git clone -b mvn-repo git@github.com:overturetool/astcreator.git git
cd mvn-repo
xcopy /s/y . ..\git\release
cd ..
cd git
git add *
git commit -m "deploy"
echo Hit enter to push
git push

