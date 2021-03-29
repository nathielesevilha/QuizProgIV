package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button verdadeButton;
    private Button falsoButton;
    private TextView perguntaTextView;
    private ImageButton voltarButton;
    private ImageButton proximoButton;


    private int currentPerguntasIndex = 0;

    private Perguntas[] perguntasBank = new Perguntas[]{
            new Perguntas(R.string.Pergunta_completa, true),
            new Perguntas(R.string.Pergunta_2, false),
            new Perguntas(R.string.Pergunta_3, false),
            new Perguntas(R.string.Pergunta_4, false),
            new Perguntas(R.string.Pergunta_5, true),
            new Perguntas(R.string.Pergunta_6, false),
            new Perguntas(R.string.Pergunta_7, true),
            new Perguntas(R.string.Pergunta_8, true),
            new Perguntas(R.string.Pergunta_9, false),
            new Perguntas(R.string.Pergunta_10, false),
            new Perguntas(R.string.Pergunta_11, false),
            new Perguntas(R.string.Pergunta_12, false),
            new Perguntas(R.string.Pergunta_13, true),
            new Perguntas(R.string.Pergunta_14, false),
            new Perguntas(R.string.Pergunta_15, true),
            new Perguntas(R.string.Pergunta_16, false),
            new Perguntas(R.string.Pergunta_17, true),
            new Perguntas(R.string.Pergunta_18, true),
            new Perguntas(R.string.Pergunta_19, true),
            new Perguntas(R.string.Pergunta_20, true),
            new Perguntas(R.string.Pergunta_21, true),
            new Perguntas(R.string.Pergunta_22, false),
            new Perguntas(R.string.Pergunta_23, true),
            new Perguntas(R.string.Pergunta_24, false),
            new Perguntas(R.string.Pergunta_25, true),
            new Perguntas(R.string.Pergunta_26, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falsoButton = findViewById(R.id.botao_falso);
        verdadeButton = findViewById(R.id.botao_verdade);
        perguntaTextView = findViewById(R.id.text_view_resposta);
        voltarButton = findViewById(R.id.voltar_botao);
        proximoButton = findViewById(R.id.proximo_botao);


        verdadeButton.setOnClickListener(this);
        falsoButton.setOnClickListener(this);
        voltarButton.setOnClickListener(this);
        proximoButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.botao_verdade:
                checkResposta(true);
                break;

            case R.id.botao_falso:
                checkResposta(false);
                break;

            case R.id.proximo_botao:
                currentPerguntasIndex = (currentPerguntasIndex + 1) % perguntasBank.length;
                updatePerguntas();
                break;

            case R.id.voltar_botao:
                if(currentPerguntasIndex > 0){
                    currentPerguntasIndex = (currentPerguntasIndex - 1) % perguntasBank.length;
                    updatePerguntas();
                }

        }

    }

    private void updatePerguntas(){
        Log.d("current","onclick" + currentPerguntasIndex);
        perguntaTextView.setText(perguntasBank[currentPerguntasIndex].getRespostaResId());

    }

    private void checkResposta(boolean usuarioEscolherCorretamente){
        boolean respostaCerta = perguntasBank[currentPerguntasIndex].isRespostaVerdade();

        int toastMensagemId = 0;
        if(usuarioEscolherCorretamente == respostaCerta){
            toastMensagemId = R.string.resposta_correta;
        }
        else{
            toastMensagemId = R.string.resposta_errada;
        }
        Toast.makeText(MainActivity.this, toastMensagemId,Toast.LENGTH_SHORT).show();
    }

}