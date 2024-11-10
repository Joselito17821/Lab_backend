package culturemedia.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;
import org.springframework.stereotype.Component;

@Component
public class ViewsRepositoryImpl implements ViewsRepository {

	private final List<View> view;

	public ViewsRepositoryImpl() {
		this.view = new ArrayList<>();
	}

	@Override
	public View save(View view) {
		this.view.add( view );
		return view;
	}
}