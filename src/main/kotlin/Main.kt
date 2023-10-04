import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

//class MyClass{
//    val a by lazy {
//        println("Вычисляем a")
//        2 * 7 + 4 + 5
//    }
//    fun m(){
//        println(a + 11)
//        println(a + 11)
//        println("Завершение работы")
//    }
//}
//
//fun main() {
//    val mc = MyClass()
//    mc.m()
//}

@Composable
@Preview
fun App() {

    var login by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var btnText by remember { mutableStateOf("Войти") }

    MaterialTheme {
        Row(Modifier.fillMaxHeight().background(Color.Black)) {
            Column(Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
            ) {
                OutlinedTextField(
                    value = login,
                    onValueChange = { login = it },
                    modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(),
                    label = { Text("Логин:") },
                )
                OutlinedTextField(
                    value = pass,
                    onValueChange = { pass = it },
                    modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text("Пароль:") },
                )
                Button(
                    onClick = {
                         btnText = "Привет, $login!"
                    },
                    modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally)
                ) {
                    Text(btnText)
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "Наше оконное приложение на JetPack Compose",
        ) {
        App()
    }
}
