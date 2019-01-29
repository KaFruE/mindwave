# mindwave
마인드웨이브를 활용한 그림그리기

1. ChangePictureWithMindwave

![noname01](https://user-images.githubusercontent.com/34204786/51887573-b1d55600-23d7-11e9-8fa7-42421ab9554b.png)

설명 : 왼쪽 원본 사진을 보고 변화된 뇌파 결과를 픽셀단위로 오른쪽에 출력
시작점 : 이미지 가로 길이 + 10 지점부터 시작
사용되는 값 : Delta 값
변경되는 점 : Delta 값에 따른 출력 색 변경
10000 이하 : RGB 중 B,G의 값을 0으로 변경
10000 이상 100000 이하 : 그대로 출력
100000 이상 : RGB 중 R의 값을 0으로 변경

2. DrawLineWithMindwave

![noname02](https://user-images.githubusercontent.com/34204786/51887581-b69a0a00-23d7-11e9-89b1-81d96ff5e8d1.png)

설명 : 가장 마지막으로 설정된 좌표(500,500부터 시작)와 X축 (집중력값), Y축 (명상력값)으로 다음 좌표를 찍고 선으로 이어서 그림을 그림 
시작점 : X : 500, Y : 500 지점
사용되는 값 :
Delta, Theta, Low_alpha, High_alpha, Low_beta, High_beta,Low_gamma, Mid_gamma, 집중력, 명상력 값
변경되는 점 : 사용되는 8개의 값 중 제일 큰 값이 지정해놓은 색으로 색을 입히고 이전 좌표와 X축(집중력값), Y축(명상력값)에 따라 선의 길이와 위치가 변경
(왼쪽 상단을 기점으로 집중력 값에 따라 오른쪽으로 명상력값에 따라 밑으로 지정되는 방법)


3. DrawPictureWithMindwave

![noname03](https://user-images.githubusercontent.com/34204786/51887584-ba2d9100-23d7-11e9-9da8-ecb658b79e0c.png)

설명 : 좌표(500,400부터 시작)부터 시작해서 여러 가지 값에 따라 8개의 방향으로 점(길이가 3인 정사각형)을 찍어 그리는 그림 
시작점 : X : 500, Y : 400 지점
사용되는 값 : 
Delta, Theta, Low_alpha, High_alpha, Low_beta, High_beta,Low_gamma, Mid_gamma, 명상력 값
변경되는 점 : 사용되는 8개의 값 중 제일 큰 값이 지정해놓은 방향으로 색을 입힘.

색은 명상력에 따라 변경

명상력 80 이상 : 보라색
명상력 70 이상 : 파랑색
명상력 60 이상 : 초록색
명상력 50 이상 : 노랑색
명상력 40 이상 : 주황색
나머지 : 빨강색

Delta값이 제일 클 때 : 위로 한칸
Theta값이 제일 클 때 : 왼쪽 위로 한칸
Low_alpha값이 제일 클 때 : 오른쪽 위로 한칸
High_alpha값이 제일 클 때 : 오른쪽으로 한칸
Low_beta값이 제일 클 때 : 왼쪽으로 한칸
High_beta값이 제일 클 때 : 왼쪽 밑으로 한칸
Low_gamma값이 제일 클 때 : 오른쪽 밑으로 한칸
Mid_gamma값이 제일 클 때 : 밑으로 한칸

왼쪽 끝에 도달한다면 오른쪽 두칸으로 이동
오른쪽 끝에 도달한다면 왼쪽 두칸 으로 이동
맨 위일 때 아래로 두칸 이동
맨 아래일 때  위로 두칸 이동

4. DrawSpiralWithMindwave

![noname04](https://user-images.githubusercontent.com/34204786/51887585-ba2d9100-23d7-11e9-9215-13734a007f1a.png)

설명 : 좌표(500,500부터 시작)부터 시작해서 사각 나선형을 그리고 집중력의 크기에 따라 나선형의 크기가 변경
시작점 : X : 500, Y : 400 지점
사용되는 값 : 
Delta, Theta, Low_alpha, High_alpha, Low_beta, High_beta,Low_gamma, Mid_gamma, 집중력 값
변경되는 점 : 사용되는 8개의 값 중 제일 큰 값이 지정해놓은 색을 입히면서 집중력 값에 따라 나선형 크기 변경

색은 명상력에 따라 변경

명상력 80 이상 : 보라색
명상력 70 이상 : 파랑색
명상력 60 이상 : 초록색
명상력 50 이상 : 노랑색
명상력 40 이상 : 주황색
나머지 : 빨강색

나선형을 그릴 때 사용되는 선 하나하나의 길이는 집중력의 값이다. 
즉, 마지막 좌표에서 집중력 값만큼 해당 X 혹은 Y의 값을 더하거나 빼서 좌표를 설정한다. 

5. GraphWithMindwave

![noname05](https://user-images.githubusercontent.com/34204786/51887586-bac62780-23d7-11e9-86b9-16f759d39331.png)

설명 : 시작 지점부터 뇌파에 따라 색을 다르게 지정하고 집중력에 따라 투명도를 다르게 설정해서 그리는 그림
시작점 : X : 5, Y : 5 지점
사용되는 값 : 
명상력, 집중력 값
변경되는 점 : 명상력값에 따라 지정해놓은 색을 입히면서 집중력 값에 따라 투명도를 변경

색은 명상력에 따라 변경

명상력 80 이상 : 보라색
명상력 70 이상 : 파랑색
명상력 60 이상 : 초록색
명상력 50 이상 : 노랑색
명상력 40 이상 : 주황색
나머지 : 빨강색

투명도는 집중력에 따라 변경

집중력 80 이상 : 투명도 100
집중력 50 이상 : 투명도 80
집중력 30 이상 : 투명도 60
나머지 : 투명도 40

6. DrawCircleSpiralWithMindwave

![noname07](https://user-images.githubusercontent.com/34204786/51887583-b994fa80-23d7-11e9-8a66-2f66921d8305.png)

설명 : 좌표(500,500) 지점에서 시작해서 집중력 값과 명상력 값에 따라 나선형의 크기를 변경
시작점 : X: 500, Y : 500
사용되는 값 : 명상력, 집중력 값
변경되는 점 : 명상력값과 집중력 값을 비교

집중력값이 명상력값보다 클 때 : 가로, 세로에 집중력 값을 더함
명상력값이 집중력값보다 클 때 : 가로, 세로에 명상력 값을 뺌

7. RandomSquareWithMindwave

![noname06](https://user-images.githubusercontent.com/34204786/51887587-bac62780-23d7-11e9-98b8-cff84d04cc82.png)

설명 : 랜덤한 지점에 뇌파에 따라 색을 다르게 지정하고 집중력에 따라 정사각형 크기를 다르게 입력해서 그리는 그림
시작점 : 랜덤한 지점
사용되는 값 : Delta, Theta, High_alpha, Low_beta, High_beta, Mid_gamma값,
집중력 값
변경되는 점 : 8개의 값중 가장 큰 값을 가진 파가 지정해놓은 색을 입히면서 집중력 값에 따라 정사각형의 크기를 변경

Delta값이 제일 클 때 : 보라색
Theta값이 제일 클 때 : 파랑색
High_alpha값이 제일 클 때 : 초록색
Low_beta값이 제일 클 때 : 노랑색
High_beta값이 제일 클 때 : 주황색
Mid_gamma값이 제일 클 때 : 빨강색

집중력이 80이상일 때 : 한변의 길이 100
집중력이 50이상일 때 : 한변의 길이 50
집중력이 30이상일 때 : 한변의 길이 30
나머지 : 한변의 길이 10
