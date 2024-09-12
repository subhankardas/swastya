# Swastya - Public Health Monitoring

Swastya is a comprehensive public health monitoring application designed to help individuals track and manage their health metrics, create personalized diet plans, and stay informed about public health trends. The application offers features ranging from vital signs monitoring to pandemic detection, ensuring users can maintain and improve their overall health and well-being.

## Features

### Health Monitoring
- **Vital Signs Tracking**: Monitor body temperature, heart rate, respiratory rate, blood pressure, and oxygen saturation.
- **Health Metrics Calculation**: Calculate BMI, BMR, and TDEE to assess weight status, caloric needs, and overall health.
- **Symptom Tracking**: Log symptoms and get suggestions for potential health issues.

### Custom Diet Plans
- **Personalized Diet Plans**: Generate diet plans based on BMI, BMR, activity level, and health goals.
- **Macronutrient Breakdown**: Get detailed macronutrient distributions and meal recommendations.
- **Food Database**: Access a comprehensive database of food items and recipes with nutritional information.

### Pandemic Detection
- **Symptom Analysis**: Analyze user-reported symptoms and provide health insights.
- **Epidemiological Data**: Integrate real-time data from public health authorities and provide alerts.
- **Contact Tracing**: Use Bluetooth-based contact tracing and exposure notifications.
- **Vaccination Tracking**: Monitor vaccination status and provide reminders for follow-up doses.

### Public Health Insights
- **Health Risk Assessment**: Assess individual risk levels and recommend preventive measures.
- **Educational Content**: Access articles, videos, and guidelines on various health topics.
- **Pandemic Dashboard**: View global and local pandemic statistics and alerts.

### Integration and Security
- **Wearable Device Integration**: Sync with wearable health monitors for automatic data collection.
- **Privacy and Security**: Ensure data encryption, secure storage, and user privacy.

## Installation

### Prerequisites
- Java 17
- Maven
- Docker
- Docker Compose

### Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/swastya.git
   cd swastya
   ```

2. **Set Up Environment Variables**
   - Create a `.env` file in the root directory and configure the necessary environment variables:
     ```env
     DATABASE_URL=your_database_url
     JWT_SECRET=your_jwt_secret
     ```

3. **Build executable JARs**
   ```bash
   mvn -U clean package -DskipTests
   ```

4. **Start the Application**
   - Using Docker:
     ```bash
     docker-compose up
     ```

5. **Access the Application**
   - Open a web browser and navigate to `http://localhost:8080` to access the application.

## API Endpoints

### Health Metrics
- **GET /api/v1/metrics**: Retrieve health metrics.
- **POST /api/v1/metrics**: Submit new health metrics.

### Diet Plans
- **GET /api/v1/diet-plans**: Retrieve personalized diet plans.
- **POST /api/v1/diet-plans**: Create a new diet plan.

### Pandemic Detection
- **GET /api/v1/pandemic-data**: Retrieve pandemic data and alerts.
- **POST /api/v1/symptoms**: Submit symptoms for analysis.

## Usage

- **Track Your Health**: Input your vital signs and health data to monitor your health status.
- **Generate Diet Plans**: Use the application to create customized diet plans based on your health metrics and goals.
- **Stay Informed**: Receive updates and alerts about pandemic situations and health risks.
- **Access Resources**: Explore educational content and resources to stay informed about health and wellness.

## Contributing

We welcome contributions to improve Swastya. To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or support, please contact us at [support@swastya.com](mailto:support@swastya.com).

---

Thank you for using Swastya! Stay healthy and informed.