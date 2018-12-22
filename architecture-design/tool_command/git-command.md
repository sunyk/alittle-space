###### GIT fork 常用命令：

~~~properties
#设置源仓库
-git remote add upstream 远程分支 
#拉取源仓库的更新
-git fetch 新创建分支
#将自己仓库的主分支合并源仓库的更新
-git co master
#合并新分支到本地master
-git merge upsteam/master
~~~



### 同步fork后的远程仓库：

~~~properties
1、添加一个远程仓库，此时只是空壳，还没有同步内容，引用 fork 的原仓库地址

git remote add originUpstream https://github.com/AFNetworking/AFNetworking.git
2、commit（提交）本地的变更；如果本地没有修改内容，此步骤可忽略

git commit
3、更新远程仓库，从引用 fork 的原仓库地址同步内容，此时原仓库的 master（主干分支）已经可以在本地访问了

git remote update originUpstream
4、checkout（检出）用于操作的本地分支 ，比如 master；如果此时分支为已检出状态，此步骤可忽略

git checkout master
5、直接从远程仓库的分支 pull（拉取） 数据

git pull originUpstream master
PS：或者本地已检出分支基于远程仓库的分支进行 rebase（变基）操作

git rebase originUpstream/master
6、把本地已检出分支的已提交数据 push（推送） 到自己 fork 的仓库中

git push origin master
~~~

### fork别人项目后更新自己的远端项目

~~~properties
1.git remote -v
2.git remote add upstream http://github/xxxxx/xxxx(项目地址)
3.git fetch upstream
4.git checkout -b dev xxx
5.git merge upstream/xxx（分支名）
6.git push origin xxx(分支名)
~~~

### git fork后如何更新

~~~properties
1.git remote add upstream URL
2.git fetch upstream
  git merge upstream/master
3.git push origin master:master
~~~

### 如何删除远程整个资源

~~~properties
git remote remove origin 删除即可
~~~

