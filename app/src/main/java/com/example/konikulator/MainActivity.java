package com.example.konikulator;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * implements - нужно для реализации интерфейса
 * implements помогает использовать нам элементы интерфейса в классе
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {
    TextView textinfo; // Объявление переменной для истории
    EditText value; // Объявление переменной ввода текста
    double valueResult, valueOne, valueTwo; // Объявление переменных с плавоющей запятой
    String his; // Объявление переменной для формирования истории
    char CURRENT_ACTION, CURRENT_ACTION_TWO; // Объявление переменных для switch
    ArrayList<String> history = new ArrayList<String>(); // Объявление массива
    // Объявление переменных (кнопок)
    Button b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_pl, b_min, b_umn, b_del, b_res, b_clear, b_lg, b_tan, b_sin, b_cos, b_x2, b_cor, b_left, b_right, b_delete, b_proc, b_p, b_toc;

    /**
     * Метод (функция) onCreate - фактически весь интерфейс приложения
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Чтобы установить ресурс разметки дизайна,
         * вызывется метод setContentView,
         * в который передается идентификатор ресурса.
         *
         * R.layout.activity_main. Фактически это и есть ссылка на
         * файл activity_main.xml, который находится в каталоге res/layout и res/layot-land
         */
        setContentView(R.layout.activity_main);
        textinfo = (TextView)findViewById(R.id.t_history); // Инициализация тектового поля, для истории
        valueResult = valueOne = valueTwo = Double.NaN; // Инициализация сразу 3 одинаковых переменных, устанавливаем пустоту - Double.NaN
        /**
         * Инициализация кнопок и текстового поля
         * (Button) – показывает тип кнопки
         * findViewById показывает, что
         * мы будет брать кнопку по его ID
         * из activity_main
         * Пример: android:id="@+id/btn_1"
         */
        b_0 = (Button)findViewById(R.id.b_0);
        b_1 = (Button)findViewById(R.id.b_1);
        b_2 = (Button)findViewById(R.id.b_2);
        b_3 = (Button)findViewById(R.id.b_3);
        b_4 = (Button)findViewById(R.id.b_4);
        b_5 = (Button)findViewById(R.id.b_5);
        b_6 = (Button)findViewById(R.id.b_6);
        b_7 = (Button)findViewById(R.id.b_7);
        b_8 = (Button)findViewById(R.id.b_8);
        b_9 = (Button)findViewById(R.id.b_9);
        b_pl = (Button)findViewById(R.id.b_pl);
        b_min = (Button)findViewById(R.id.b_min);
        b_umn = (Button)findViewById(R.id.b_umn);
        b_del = (Button)findViewById(R.id.b_del);
        b_res = (Button)findViewById(R.id.b_res);
        b_clear = (Button)findViewById(R.id.b_clear);
        b_lg = (Button)findViewById(R.id.b_lg);
        b_tan = (Button)findViewById(R.id.b_tan);
        b_sin = (Button)findViewById(R.id.b_sin);
        b_cos = (Button)findViewById(R.id.b_cos);
        b_x2 = (Button)findViewById(R.id.b_x2);
        b_cor = (Button)findViewById(R.id.b_cor);
        b_left = (Button)findViewById(R.id.b_left);
        b_right = (Button)findViewById(R.id.b_right);
        b_delete = (Button)findViewById(R.id.b_delete);
        b_proc = (Button)findViewById(R.id.b_proc);
        b_p = (Button)findViewById(R.id.b_p);
        b_toc = (Button)findViewById(R.id.b_toc);
        value = (EditText)findViewById(R.id.t_view);


        /**
         * Проверка на версию SDK
         * LOLLIPOP - Ноябрь 2014
         * Если SDK_INT новее ноября 2014, используем метод:
         *      setShowSoftInputOnFocus(false);
         * Иначе
         *      setTextIsSelectable(true);
         *
         * Необходимо для отключения всплывающей клаиватуры
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            value.setShowSoftInputOnFocus(false);
        } else {
            value.setTextIsSelectable(true);
        }

        /**
         * Метод обратоки нажатия на кнопки
         */
        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);
        b_pl.setOnClickListener(this);
        b_min.setOnClickListener(this);
        b_umn.setOnClickListener(this);
        b_del.setOnClickListener(this);
        b_res.setOnClickListener(this);
        b_clear.setOnClickListener(this);
        /**
         * Проверка на поворот
         * Вертикальныя == 1
         * Горизонтальная == 2
         *
         * Т.к. у нас на горизонтальной больше кнопок
         * и чтобы избежать ошибки или закрытие программы
         * будет обрабатывать наши кнопки только при
         * вертикальном повороте
         */
        if(getResources().getConfiguration().orientation == 2){
            b_lg.setOnClickListener(this);
            b_tan.setOnClickListener(this);
            b_sin.setOnClickListener(this);
            b_cos.setOnClickListener(this);
            b_x2.setOnClickListener(this);
            b_cor.setOnClickListener(this);
            b_left.setOnClickListener(this);
            b_right.setOnClickListener(this);
            b_delete.setOnClickListener(this);
            b_proc.setOnClickListener(this);
            b_p.setOnClickListener(this);
            b_toc.setOnClickListener(this);
        }
    }

    /**
     * Метод onRestoreInstanceState - необходим для восстановления нашей истории
     * при повороте экрана, данный метод вызывается автоматически при каждом повороте
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        /**
         * Присваем в нашу переменную history
         * Сохраненный до поворота массив под название ("history")
         */
        history = savedInstanceState.getStringArrayList("history");
        /**
         * Вызываем метод getHistory, чтобы отобразить на экране сохранения
         */
        getHistory();
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Аналогично верхнему, только этот метод нужен для сохранения
     * чтобы потом можно было восстановить
     * Данный метод, так же вызывается автоматически
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /**
         * Сохраняем массив под названием: ("history"
         * через запятую укзываем, что будем сохранять
         * в данном случае наш массив history
         */
        outState.putStringArrayList("history", history);
    }

    /**
     * Булиевый метод (может иметь значение true либо false)
     * Нужен для проверки на то, что у нас поле не будет пустое
     *
     * т.е. обязательно должны быть введены цыфры
     *
     * Если поле не пустое, возвращает true
     * если пустое, то false
     */
    private boolean checkValue(){
        if(value.getText().toString().length() != 0)
            return true;
        return false;
    }

    /**
     * Метод обработки нажатия кнопок
     * View view - где:
     *      View (с большой буквы) - тип данных, как Button, String и т.д.
     *      позволяет опознать нажатую клавишу с помощью метода view.getId()
     *
     *      view (с маленькой буквы) - просто переменная, т.к. напрямую с
     *      типом данных мы не можем работать)))
     */
    @Override
    public void onClick(View view) {
        /**
         * switch - обычный цикл с условиями
         * case - грубо говоря IF, тоже самое:
         *                          if(view.getId() == R.id.b_0){
         *
         *
         * тут мы отлавливаем нажатые клавишы и выполняем опред. действия
         */
        switch (view.getId()) {
            /**
             * value - наша переменная, которая отвечает за текстовое поле
             * Ниже обрабатываем нажатие кнопок от 0 до 1
             * с помощью метода setText - value.setText(
             *
             * value.getText() - показывает уже введённые данные, пример уже
             * введено 567 и мы нажали 0
             *
             * value.setText(567 + 0) = 5670
             * Т.к. это String - текст, то он их не складывает, а добавляет с краю
             *
             * Если нам нужно было бы в начале добавить к примеру 1 уже к текущему
             * значению, было бы так:
             *                      value.setText("1" + value.getText());
             *
             *                      получилось бы: 1567
             *                      т.к. value.getText() = 567
             */
            case R.id.b_0: {value.setText(value.getText() + "0");} break;
            case R.id.b_1: {value.setText(value.getText() + "1");} break;
            case R.id.b_2: {value.setText(value.getText() + "2");} break;
            case R.id.b_3: {value.setText(value.getText() + "3");} break;
            case R.id.b_4: {value.setText(value.getText() + "4");} break;
            case R.id.b_5: {value.setText(value.getText() + "5");} break;
            case R.id.b_6: {value.setText(value.getText() + "6");} break;
            case R.id.b_7: {value.setText(value.getText() + "7");} break;
            case R.id.b_8: {value.setText(value.getText() + "8");} break;
            case R.id.b_9: {value.setText(value.getText() + "9");} break;

            /**
             * Далее обработка логических кнопок, таких как +, -, * (всех остальных короче)
             *
             */
            case R.id.b_pl: {
                /**
                 * checkValue - метод описанный выше, чтобы не поднимать
                 * я опишу ещё раз тут, чтобы было понимание как работает
                 *
                 * checkValue -
                 * Булиевый метод (может иметь значение true либо false)
                 *      * Нужен для проверки на то, что у нас поле не будет пустое
                 *      *
                 *      * т.е. обязательно должны быть введены цыфры
                 *      *
                 *      * Если поле не пустое, возвращает true
                 *      * если пустое, то false
                 *
                 *      if(checkValue()) - если наше поле не пустое, то код выполняеться
                 *      если наше текстовое поле пустое, то код не выполнится
                 *
                 *      Если конкретнее:
                 *                     preCalc();
                 *                     CURRENT_ACTION = '+';
                 *                     value.setText("");
                 *
                 *                     Либо выполниться, либо нет
                 */
                if(checkValue()) {
                    /**
                     * Обращаемся к методу
                     * Да кстате, метод, функция - одно и тоже))
                     *
                     * Метод preCalc() - находиться ниже
                     * Тут важна последовательность, preCalc должен стоять раньше
                     * чем CURRENT_ACTION и value.setText(......
                     *
                     * preCalc - выполняет математические действия, как он работает
                     * описан ниже
                     *
                     * Но нужно понимать, что он выполняет предыдущее действие, т.е.
                     *
                     * ты вводишь к примеру 5 +
                     * Т.к. в начале CURRENT_ACTION - пустой, preCalc внутри себя
                     * присвоит переменной valueOne = 5
                     *
                     * После того, как метод preCalc сделал свои дела (valueOne = 5)
                     * Мы присвоим CURRENT_ACTION = '+"
                     * и очистим наше поле
                     *                      value.setText("");
                     *
                     * Далее мы вводим ещё раз 4 + (в итоге уже 5 + 4 +)
                     * и когда мы приходим обратно сюда, то preCalc() увидит, что у нас
                     * CURRENT_ACTION = '+' и возьмет данные из valueOne = 5 и приплюсует к
                     * ему наше текущее поле (value.getText(), а он у нас равен = 4)
                     * Далее итог: 9 запишеться в valueResult и в valueOne - всё это выполняеться
                     * в методе preCalc()!!!!!
                     *
                     * Далее у нас в CURRENT_ACTION = опять заносится +
                     * и очищаеться поле ввода: value.setText("");
                     *
                     * Далее мы вводим ещё раз к примеру 8+ (в итоге уже 5 + 4 + 8 +)
                     * и когда мы приходим обратно сюда, то preCalc() увидит, что у нас
                     * CURRENT_ACTION = '+' - с прошлого раза и возьмет данные из valueOne = уже 9 и приплюсует к
                     * ему наше текущее поле (value.getText(), а он у нас равен = 8)
                     * Далее итог: 17 запишеться в valueResult и в valueOne
                     *
                     * Далее у нас в CURRENT_ACTION = опять заносится +
                     * и очищаеться поле ввода: value.setText("");
                     *
                     * Аналогично с другими логическими операциями, кроме скобок и tan, cos, sin
                     * Подробнее будет описано ниже в методе preCalc
                     */
                    preCalc();
                    CURRENT_ACTION = '+';
                    value.setText("");
                }
            }
            break;
            case R.id.b_min: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '-';
                    value.setText("");
                }
            }
            break;
            case R.id.b_umn: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '*';
                    value.setText("");
                }
            }
            break;
            case R.id.b_del: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '/';
                    value.setText("");
                }
            }
            break;
            case R.id.b_res: {
                if(checkValue()) {
                    preCalc();
                    /**
                     * Тут обработка кнопки равно =
                     * value.setText - выводит в наше текстовое поле результат
                     *
                     * Double.toString - конвертирует данные из double (плавающая запятая)
                     * в Текст
                     *
                     * Далее getHistory обновляет нашу историю на экране,
                     * данный метод описан ниже
                     *
                     * И далее обнуляем наши переменные:
                     * valueResult = valueOne = valueTwo - все три будут равны = Double.NaN
                     * Double.NaN описан выше где-то в начале)))
                     */
                    value.setText(Double.toString(valueResult));
                    getHistory();
                    valueResult = valueOne = valueTwo = Double.NaN;
                }
            }
            break;
            case R.id.b_clear: {
                /**
                 * Кнопка Clear - очищает поле ввода
                 * value.setText("");
                 * и далее очищает наши переменные, где могут быть
                 * результаты выполнения логических операций:
                 *
                 * valueResult = valueOne = valueTwo = Double.NaN;
                 */
                value.setText("");
                valueResult = valueOne = valueTwo = Double.NaN;
            }
            break;
            case R.id.b_lg: {
                if(checkValue()) {
                    preCalc();
                    /**
                     * Ах да, чуть не забыл, т.к. переменная
                     * CURRENT_ACTION имеет тип: char
                     * то данная переменная, может хранить только один символ
                     *
                     * l - логорифм, нельзя написать к примеру:
                     * CURRENT_ACTION = 'log';
                     */
                    CURRENT_ACTION = 'l';
                }
            }
            break;
            case R.id.b_tan: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 't';
                }
            }
            break;
            case R.id.b_sin: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 's';
                }
            }
            break;
            case R.id.b_cos: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 'c';
                }
            }
            break;
            case R.id.b_x2: {
            }
            break;
            case R.id.b_cor: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 'q';
                }
            }
            break;
            case R.id.b_left: {
                /**
                 * Обработка скобок )))
                 *
                 * Я шёл от принципа: 5 + (5 / 2) = 7,5
                 * при обычном варианте: 5 + 5 / 2 = 5, такой ответ, т.к. каждое действие у нас отдельно
                 * обрабатываеться, пример:
                 * 5 + 5 - 2 * 10 / 2 = 40
                 * 5 + 5 = 10 - 2 = 8 * 10 = 80 / 2 = 40
                 *
                 * Поэтому
                 * 5 + 5 = 10 / 2 = 5
                 *
                 * По сути, нам нужно сохранить последовательность
                 * 5 + ( 5 / 2 ), что 5 + скобки, чтобы если был минус
                 * то мы от 5 минусовали скобки, а не наоборот
                 *
                 * Таким образом, мы сохраняем наш + в CURRENT_ACTION_TWO из CURRENT_ACTION
                 * Далее мы в CURRENT_ACTION обнуляем
                 *
                 * Так же мы в valueTwo - присваем 5 из valueOne
                 * valueTwo = valueOne;
                 *
                 * Далее мы valueOne и valueResult обнуляем
                 *
                 * По сути, мы наш 5 + который перед скобками, сохранили отдельно
                 * Чтобы выполнять скобки
                 */
                CURRENT_ACTION_TWO = CURRENT_ACTION;
                CURRENT_ACTION = '0';
                valueTwo = valueOne;
                valueOne = valueResult = Double.NaN;
            } break;
            case R.id.b_right: {
                if(checkValue()) {
                    /**
                     * После всех операций, нужно закрыть скобку
                     * и мы приходим сюда
                     * и выполняем preCalc - который сделает все наши
                     * логические операции
                     *
                     * Т.к. наши скобки решились, а это у нас 5 / 2 = 2.5
                     * Нам нужно вернуть последовательность 5 + 2.5
                     *
                     * Наше 5 и операция + храняться в:
                     * valueTwo и в CURRENT_ACTION_TWO
                     *
                     * Мы присваиваем CURRENT_ACTION, наш + из CURRENT_ACTION_TWO
                     * Далее мы присваиваем valueOne, нашу 5 из valueTwo
                     * И далее мы выводим результат в наше текстовое поле ввода
                     * value.setText(Double.toString(valueResult));
                     *
                     * Вот и всё) при нажатии далее равно, у нас обработается 5+2,5=7.5
                     */
                    preCalc();
                    CURRENT_ACTION = CURRENT_ACTION_TWO;
                    valueOne = valueTwo;
                    value.setText(Double.toString(valueResult));
                }
            } break;
            case R.id.b_delete: {
                /**
                 * Удаление - поцифренное
                 * У нас к примеру есть 58952
                 * value.getText() - 58952
                 * метод .toString() преобразует его в текстовое поле
                 * далее метод .substring - отризает то, что нам не нужно, по заданным параметрам
                 *
                 * .substring - принимает в себя 2 параметра
                 * от куда и до куда
                 */
                value.setText(value.getText().toString().substring(0, value.getText().toString().length() - 1));
            }
            break;
            case R.id.b_proc: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '%';
                    value.setText("");
                }
            }
            break;
            case R.id.b_p: {
                value.setText("3.14159265");
            }
            break;
            case R.id.b_toc: {
                if(checkValue())
                    value.setText(value.getText().toString().replace(".", "") + ".");
                else
                    value.setText("0.");
            }
            break;
            default:
                value.setText(value.getText());
        }
    }

    private void getHistory(){
        his = "";
        for(int i = 0; i < history.size(); i++){
            his += history.get(i) + "\r\n";
        }
        textinfo.setText(his);
    }

    private boolean checkValOne(){
        if(Double.isNaN(valueOne)){
            valueOne = Double.parseDouble(value.getText().toString());
            return true;
        }
        return false;
    }

    public void preCalc(){
        switch (CURRENT_ACTION) {
            case '+': {
                if(!checkValOne()) {
                    valueResult = valueOne + Double.parseDouble(value.getText().toString());
                    history.add(String.valueOf(valueOne) + " + " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '-': {
                if(!checkValOne()) {
                    valueResult = valueOne - Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " - " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '*': {
                if(!checkValOne()) {
                    valueResult = valueOne * Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " * " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '/': {
                if(!checkValOne()) {
                    valueResult = valueOne / Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " / " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'l': {
                if(!checkValOne()) {
                    valueResult = Math.log10(valueOne);
                    history.add("log10(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 't': {
                if(!checkValOne()) {
                    valueResult = Math.tan(Math.toRadians(valueOne));
                    history.add("tan(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 's': {
                if(!checkValOne()) {
                    valueResult = Math.sin(Math.toRadians(valueOne));
                    history.add("sin(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'c': {
                if(!checkValOne()) {
                    valueResult = Math.cos(Math.toRadians(valueOne));
                    history.add("cos(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'q': {
                if(!checkValOne()){
                    valueResult = Math.sqrt(valueOne);
                    history.add("√" + String.valueOf(valueOne) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case '%': {
                if(!checkValOne()){
                    valueResult = (valueOne / 100) * Double.parseDouble(value.getText().toString());
                    history.add(String.valueOf(valueOne) + " % " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;
            default:
                valueOne = Double.parseDouble(value.getText().toString());
                break;
        }
    }
}
