/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadTest;

/**
 Решение достаточно простое — мы создаем форму, на которую кладем текстовый
 * компонент класса JLabel. Подготовка необходимых параметров происходит в 
 * конструкторе класса SimpleClock (строки 17-31). Здесь мы устанавливаем 
 * заголовок окна, потом создаем шрифт и устанавливаем его у текстового компо-
 * нента clockLable. Потом кладем компонент на форму и устанавливаем уже размеры
 * формы. В самом конце (строки 35-36) создаем класс для потока MyThread и за-
 * пускаем его. Также класс SimpleClock имеет метод setTime, который получает 
 * текущее время путем вызова Calendar.getInstance().getTime()) и преобразует 
 * его в строку с помощью объекта класса SimpleDateFormat (строки 46-50). 
 * Этот метод надо будет вызывать из потока.
В классе MyThread есть несколько моментов, на которые я хочу обратить ваше 
* внимание.
1. Наш поток должен вызывать метод setTime у объекта класса SimpleClock. 
*   Для этого поток должен иметь ссылку на этот объект — я описывал это в 
*   статье Отношения меду классами. Но как передать этот объект в метод run 
*   — там же нет параметров. Наиболее удобным способом (на мой взгляд) является
*   создание полей в классе-потоке, для хранения ссылок на нужные объекты и 
*   инициализация их путем передачи параметров. Я сделал это в виде параметра 
*   для конструктора, но точно также можно сделать это через вызовы сеттеров 
*   (предлагаю вам самим реализовать такой вариант — это несложно). 
*   Теперь внутри метода run мы имеем доступ к нужному нам объекту через поле
*   clock.
2. Наш метод run делает бесконечный цикл — условие вечно истинное. Т.е. наш 
*   поток может исполнятся теоретически бесконечно. Как его правильно останав-
*   ливать — узнаем чуть позже. А пока обратим внимание, что внутри нашего 
*   бесконечного цикла мы делеаем очень простую работу — вызываем метод для 
*   обновления времени и потом засыпаем на посекунды.

Если быть более точным, то наш метод setTime обновляет графический компонент 
* достаточно некорректно. На самом деле мы дожны использовать специальный поток
* (да, JVM запускает отдельный поток именно для графики). 
*  Вот более корректный вариант — пока не буду его комментировать. 
*  Просто примите как данность — графика не просто так должна обновляться, 
*  а с помощью специального вызова — создается расширяющий интерфейс Runnable 
*  класс и он отдается классу SwingUtilities, который вызовет его в нужное время.
 * 
 * @author vitco
 */
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
 
public class SimpleClock extends JFrame
{
    private JLabel clockLabel = new JLabel();
    
    public SimpleClock() {
        // Установить заголовок
        setTitle("ClockThread");
 
        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
 
        // Добавить метку на основную панель окна
        getContentPane().add(clockLabel);
 
        // Установить размеры окна
        setBounds(400, 300, 300, 100);
 
        // ОБРАТИТЬ ВНИМАНИЕ !!!
        // Создаем отдельный поток, который должен обновлять значение метки
        Thread thr = new MyThread(this);
        thr.start();
    }
    
    public void setTime() {
        // Создаем объект для форматирования даты
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Устанавливаем новое значение для метки - сразу форматируем дату в строку и устанавливаем новый текст
        clockLabel.setText(df.format(Calendar.getInstance().getTime()));
    }
    
    public static void main(String[] args) {
        SimpleClock cl = new SimpleClock();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
 
 
class MyThread extends Thread {
 
    private SimpleClock clock;
 
    public MyThread(SimpleClock clock) {
        this.clock = clock;
    }
 
    @Override
    public void run() {
        while (true) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}