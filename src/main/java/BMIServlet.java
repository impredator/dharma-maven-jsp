import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BMIServlet", urlPatterns = "/bmi")
public class BMIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));

            String bmiResult = estimateRMI(bmi);

            request.setAttribute("bmiResult", bmiResult);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("/WEB-INF/index.jsp");
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    private String estimateRMI(double bmi) {
        String result = "";
        if(bmi < 18.5) {
            result = "Skinny";
        } else if(bmi < 25) {
            result = "Normal";
        } else if(bmi < 30) {
            result = "Obesity intention";
        } else if(bmi < 35) {
            result = "Obesity 1";
        } else if(bmi < 40) {
            result = "Obesity 2";
        } else {
            result = "Obesity";
        }
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
