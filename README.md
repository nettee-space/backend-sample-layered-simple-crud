# Introduction.

이 샘플 프로젝트는 복잡한 개념을 최대한 덜어내고,
기본적인 CRUD 동작에 집중하여 코드 스타일에 적응할 수 있도록 안내합니다.

다음 항목을 포함합니다.

- 레이어드 아키텍처의 대표적인 구현을 따릅니다. (Controller - Service - Repository)
- Spring Data JPA를 사용합니다.

# Prerequisites

- JDK 21  
  You can use OpenJDK e.g. Amazon Corretto 21
- Docker Compose  
  If you install [docker desktop](https://www.docker.com/products/docker-desktop/),
  docker compose will be installed at the same time.

# Installation & Execution

Download project:

```shell
git clone git@github.com:nettee-space/sample-layered-simple-crud.git
```

도커를 실행하고, 프로젝트 경로에서 다음 명령을 입력합니다.

```shell
docker compose up -d
```

VM 옵션에 액티브 프로파일을 입력합니다.

<details>
<summary>액티브 프로파일 입력란이 있을 때</summary>

다음을 입력합니다.

```shell
local
```

</details>

<details>
<summary>VM Option을 직접 입력할 때</summary>

다음을 입력합니다.

```shell
-Dspring.profiles.active=local
```

</details>

이제 실행할 준비가 완료되었습니다.