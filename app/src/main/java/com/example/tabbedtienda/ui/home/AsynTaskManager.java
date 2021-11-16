package com.example.tabbedtienda.ui.home;

import android.content.Context;

public class AsynTaskManager {

	private AsyncTaskClass instance;

	public AsyncTaskClass getInstance(Context context) {
		if(!(instance == null)){
			return instance;
		}else{
			instance = new AsyncTaskClass(context);
			return instance;
		}
	}
}
