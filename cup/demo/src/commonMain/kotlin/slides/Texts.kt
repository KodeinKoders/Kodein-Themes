package slides

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import net.kodein.cup.Slide


val texts by Slide {

    Text("Title of the slide", style = MaterialTheme.typography.displayMedium)

    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin rutrum dignissim pulvinar. Quisque pretium nec augue quis placerat. Morbi nisl ipsum, semper a dapibus at, euismod sit amet arcu. Aliquam vestibulum facilisis tincidunt. Aenean ultrices ultricies viverra. Curabitur at sagittis orci, a vehicula nunc. Curabitur orci erat, mollis et lorem sit amet, tempus pulvinar dolor.")

}