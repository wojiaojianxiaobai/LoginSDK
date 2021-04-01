package com.wb.google;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.wb.wblogin.api.WbBaseCallback;
import com.wb.wblogin.api.WbLoginCallback;
import com.wb.wblogin.api.WbLogoutCallback;
import com.wb.wblogin.api.WbSdkApi;

import org.jetbrains.annotations.NotNull;

public class GooglePlaySdk implements WbSdkApi {
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";

    @Override
    public void init(@NotNull Activity activity, @NotNull WbBaseCallback wbBaseCallback) {
        String clientId = "YOUR_SERVER_CLIENT_ID";
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(clientId)
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
    }

    @Override
    public void login(@NotNull Activity activity, @NotNull WbLoginCallback wbLoginCallback) {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onCreate(@NotNull Activity activity) {

    }

    // [START handleSignInResult]
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.

            //todo 登录成功

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());

            //todo 登录失败
        }
    }

    // [END handleSignInResult]


    // [START signOut]
    private void signOut(Activity activity) {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(activity, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        //todo 登出账号

                        // [END_EXCLUDE]
                    }
                });
    }
    // [END signOut]

    @Override
    public void onStart(@NotNull Activity activity) {

    }

    @Override
    public void onResume(@NotNull Activity activity) {

    }

    @Override
    public void onPause(@NotNull Activity activity) {

    }

    @Override
    public void onStop(@NotNull Activity activity) {

    }

    @Override
    public void onDestroy(@NotNull Activity activity) {

    }

    @Override
    public void pay(@NotNull Activity activity) {

    }

    @Override
    public void onActivityResult(@NotNull Activity activity, int requestCode, int resultCode, @NotNull Intent data) {
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    @Override
    public void logout(@NotNull Activity activity, @NotNull WbLogoutCallback logoutCallback) {
        signOut(activity);
    }

    @Override
    public void sendRoleCreateData(@NotNull Activity activity) {

    }

    @Override
    public void sendRoleLoginData(@NotNull Activity activity) {

    }

    @Override
    public void sendRoleLevelData(@NotNull Activity activity) {

    }

    @Override
    public void sendRoleExitData(@NotNull Activity activity) {

    }
}
