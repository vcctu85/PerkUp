package com.example.macbook.perkupapp;

import android.app.Activity;
import android.os.AsyncTask;

import ai.api.AIServiceContext;
import ai.api.AIServiceException;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

public class RequestTask extends AsyncTask<AIRequest, Void, AIResponse> {
    private AIServiceContext context;
    Activity activity;
    private AIDataService aiDataService;


    RequestTask(AIServiceContext customAIServiceContext, Activity activity, AIDataService aiDataService){
        this.activity = activity;
        this.aiDataService = aiDataService;
        this.context = customAIServiceContext;
    }

    @Override
    protected AIResponse doInBackground(AIRequest... aiRequests) {
        final AIRequest request = aiRequests[0];
        try {
            return aiDataService.request(request, context);
        } catch (AIServiceException e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(AIResponse aiResponse) {
        ((ChatActivity)activity).callback(aiResponse);
    }
}
