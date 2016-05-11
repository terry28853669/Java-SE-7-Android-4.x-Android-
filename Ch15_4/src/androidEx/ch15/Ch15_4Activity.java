package androidEx.ch15;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Ch15_4Activity extends ListActivity {
	private String[] portals;
	private String[] links;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ���o�r��}�C�귽
        portals = getResources().getStringArray(R.array.portal_sites);
        links = getResources().getStringArray(R.array.portal_urls);
        // �إ�ArrayAdapter����
        ArrayAdapter<String> a = new ArrayAdapter<String>(
      		this, android.R.layout.simple_list_item_1, portals);
        setListAdapter(a);  // ���w���X������
    }
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String url = links[position];  // ���o���}
		Toast.makeText(this, portals[position],
				Toast.LENGTH_SHORT).show();
		// �Ұ��s���{��
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(intent);
	}
}