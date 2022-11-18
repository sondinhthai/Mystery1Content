package com.example.mystery1content.controller;

import com.example.mystery1content.model.Language;
import com.example.mystery1content.service.LanguageService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class HomeController {
    public Language getCurrentTag(String android_id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection("CurrentTag").document(android_id);

        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();

        DocumentSnapshot documentSnapshot = apiFuture.get();

        if (documentSnapshot.exists()) {
            return documentSnapshot.toObject(Language.class);
        } else {
            return null;
        }
    }

    @GetMapping("/JeffTheKiller/{android_id}")
    public String jeffTheKiller(@PathVariable String android_id) throws ExecutionException, InterruptedException {
        Language languages = new Language();
        languages = getCurrentTag(android_id);

        if (languages.getTag().equals("vi")) {
            return "JeffTheKiller/JeffTheKiller_vi";
        } else if (languages.getTag().equals("en")) {
            return "JeffTheKiller/JeffTheKiller_en";
        }
        return "JeffTheKiller/JeffTheKiller_en";
    }

    @GetMapping("/ElisaLam/{android_id}")
    public String elisaLam(@PathVariable String android_id) throws ExecutionException, InterruptedException {
        Language languages = new Language();
        languages = getCurrentTag(android_id);

        if (languages.getTag().equals("vi")) {
            return "ElisaLam/ElisaLam_vi";
        } else if (languages.getTag().equals("en")) {
            return "ElisaLam/ElisaLam_en";
        }
        return "ElisaLam/ElisaLam_en";
    }

    @GetMapping("/InunakiVillage/{android_id}")
    public String inunakiVillage() {
        return "InunakiVillage/InunakiVillage";
    }
}
