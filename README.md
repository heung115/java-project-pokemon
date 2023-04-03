# java-project-pockemon

### 우선 github 간단정리 부터

## **1. 용어 정리**
##### 나도 잘모르니까 정확한 정보가 아닐수 있음 :)
* 로컬 저장소 : 로컬에 자신이 제작한 소스코드 정리   
* 원격 저장소 : 서버(깃허브)에 저장되어 있는 저장소. 로컬에서 작업하고 원격에 업로드하는 방식을 사용
* Repository : git으로 관리되는 파일이나 코드같은 것들이 저장된 프로젝트의 저장소 

### 명령어
* branch[브랜치] : 분기점. 원격 저장소에 중심이 되는 main 브랜치가 있고, 작업할 때 본인의 브랜치에 작업을 하며, 작업 완료시 Pull Request를 보내서 메인 브랜치로 병합  
* add : 본인 로컬에서 작업한 파일에 대한 변경을 깃이 추적함(변경을 기록해서 깃에 올릴수 있게함)  
* commit[커밋] : add로 추적상태가 된 파일을 로컬 git에 저장(커밋 메시지랑 같이 올림[수정된 내용을 알려주는 메시지 같은것들])  
* push : commit으로 로컬git에 저장된 파일을 원격저장소에 올림  
* pull : 원격저장소의 데이터를 로컬로 가져옴. 수시로 pull을해서 수정사항을 업데이트 해줘야함.  
* merege : 서로 다른 branch를 병합해준다.

## 2.branch
### **!!!!!!!!!중요!!!!!!!**  
본인 이름의 branch를 생성해서 거기에 수정한 파일을 pull하고 다같이 확인후 pull request로 main branch로 업데이트!
main branch로 pull보내면 살짝 곤란..
<br>  
## 3. 소스코드 업로드 과정 
1. 본인의 branch로 이동 

```bash
$ git checkout [본인의 branch]
```
2. 그 후 자신의 branch에서 코드 작성 및 수정 후 orging으로 push 

```bash
$ git push origin [본인의 branch]
```
3. 그 후 깃허브 Repository로 이동하면 pull requset를 보낼 수 있는 버튼이 있는데, 거기서 제목과 내용을 알맞게 작성해서 풀 리퀘스트를 보내면 남은 팀원이 이를 확인 및 토론 후 main branch로 merge한다.
