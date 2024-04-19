import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudhi.synrgyrecchall3.R

class KataAdapter(private val kataList: List<String>) : RecyclerView.Adapter<KataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_abjad, parent, false)
        return KataViewHolder(view)
    }

    override fun onBindViewHolder(holder: KataViewHolder, position: Int) {
        holder.bind(kataList[position])
        val list = kataList.get(position)
        val context = holder.itemView.context
        holder.kataTextView.text = list
        holder.itemView.setOnClickListener {
            val url = "https://www.google.com/search?q=$list"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = kataList.size
}

class KataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val kataTextView: TextView = itemView.findViewById(R.id.tvabjad)

    fun bind(kata: String) {
        kataTextView.text = kata
    }
}
