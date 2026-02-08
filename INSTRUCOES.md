# 🅿️ Parking API - Clean Architecture

API para gestão de parque de estacionamento, desenvolvida em Java 17 com Spring Boot. O projeto foca em alta coesão e baixo acoplamento, utilizando os princípios de **Clean Architecture** e **DDD**.

---

## 🚀 Como Rodar a Aplicação Localmente

### 1. Pré-requisitos
* **Java 21** ou superior instalado.
* **Docker** e **Docker Compose** instalados e em execução.
* **Gradle** (opcional, o projeto inclui o `gradlew`).

### 2. Iniciar a Base de Dados (PostgreSQL)
A aplicação está configurada para persistir dados num container PostgreSQL. Suba o ambiente com:
```bash
docker-compose up -d

3. Compilar e Executar
Para garantir que a base de dados seja populada corretamente pelo data.sql e a aplicação suba, execute:
./gradlew bootRun
A API estará disponível em: http://localhost:8080

Exemplos de Chamadas (cURL)

1. Listar Vagas (GET)
Útil para verificar quais as 50 vagas disponíveis e os seus IDs (1 a 50).

curl -X GET http://localhost:8080/spots

2. Check-in de Veículo (POST)
O sistema reserva automaticamente a primeira vaga livre (menor ID).

curl -X POST http://localhost:8080/tickets/checkin \
  -H "Content-Type: application/json" \
  -d '{"plate": "ABC-1234"}'

3. Check-out de Veículo (POST)
Regista a saída, calcula o valor e liberta a vaga imediatamente no banco de dados.

curl -X POST http://localhost:8080/tickets/checkout \
  -H "Content-Type: application/json" \
  -d '{"plate": "ABC-1234"}'
  
Estrutura de Camadas
Domain: Entidades de negócio e regras (Ticket, ParkingSpot).

Application: Casos de uso (Check-in, Check-out) e Portas.

Infrastructure: Adaptadores de persistência (PostgreSQL), Mappers e Controllers.

Notas Técnicas
Seeding: No arranque, o script data.sql gera automaticamente 50 vagas numeradas.

Persistência: Utiliza defer-datasource-initialization para garantir que o Hibernate crie as tabelas antes da inserção dos dados iniciais.
