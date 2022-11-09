package com.unir.appcomprasv2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox chekarroz, chekfeijao, chekmacarrao, cheknescau, chekleite, chekazeite;
    private TextView txt_valor;
    private EditText pagcliente;
    private Button btn_pagamento;

    private RadioGroup rb_group,radioGroupProd;

    private double valorprod = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicacomponetes();

        checkarprecos();

        btn_pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this,R.style.back_dialog);
                janela.setTitle("Compras");
                janela.setIcon(R.drawable.carrinho);
                janela.setNeutralButton("ok", null);

                if (pagcliente.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Insira o valor a ser pago!", Toast.LENGTH_SHORT).show();
                } else {


                    //-----------------------------------
                    double valortotal = 0;

                    int op = rb_group.getCheckedRadioButtonId();

                    String desconto = "";

                    double valorCliente = Double.parseDouble(pagcliente.getText().toString());

                    if (valorprod==0){
                        Toast.makeText(MainActivity.this, "Escolha seu pedido!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (op == R.id.semdesconto) {
                            valortotal = valorprod;
                            desconto = "Sem Desconto";
                        }
                        if (op == R.id.radiocinco) {
                            valortotal = valorprod - (valorprod * 0.05);
                            desconto = "5%";
                        }
                        if (op == R.id.radiodez) {
                            valortotal = valorprod - (valorprod * 0.1);
                            desconto = "10%";
                        }
                        if (op == R.id.radioquinze) {
                            valortotal = valorprod - (valorprod * 0.15);
                            desconto = "15%";
                        }

                        double troco = valorCliente - valortotal;


                        if (valorCliente >= valortotal) {
                            janela.setMessage("Valor total: " + valortotal + "\n\nDesconto: " + desconto +
                                    "\n\nValor pago R$ " + valorCliente + "\n\nTroco R$ " + troco);
                            janela.show();

                        } else {
                            double v = valorCliente - valortotal;
                            janela.setMessage(String.format("Valor incompatível com a compra!\n\tFalta R$ %5.2f", v));
                            janela.show();
                        }
                    }
                }
            }
        });
    }

    private void inicacomponetes() {

        radioGroupProd= findViewById(R.id.radioprod);

        chekarroz = findViewById(R.id.arroz);
        chekfeijao = findViewById(R.id.feijao);
        chekmacarrao = findViewById(R.id.macarrao);
        cheknescau = findViewById(R.id.nescau);
        chekleite = findViewById(R.id.leite);
        chekazeite = findViewById(R.id.azeite);

        txt_valor = findViewById(R.id.txt_valor);
        rb_group = findViewById(R.id.radioGroup);

        pagcliente = findViewById(R.id.pagamento);

        btn_pagamento = findViewById(R.id.btn_pagamento);
    }


    private void checkarprecos() {
        chekarroz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (chekarroz.isChecked()){
                    valorprod += 7;
                }if (!chekarroz.isChecked()) {
                    valorprod -= 7;
                }


                txt_valor.setText("Valor R$ " + valorprod);
            }
        });

        chekfeijao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (chekfeijao.isChecked()){
                    valorprod += 5;
                }if (!chekfeijao.isChecked()) {
                    valorprod -= 5;
                }


                txt_valor.setText("Valor R$ " + valorprod);
            }
        });

        chekmacarrao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chekmacarrao.isChecked()){
                    valorprod += 6;
                }if (!chekmacarrao.isChecked()) {
                    valorprod -= 6;
                }

                txt_valor.setText("Valor R$ " + valorprod);
            }
        });

        chekleite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chekleite.isChecked()){
                    valorprod += 5.50;
                }if (!chekleite.isChecked()) {
                    valorprod -= 5.50;
                }

                txt_valor.setText("Valor R$ " + valorprod);
            }
        });

        chekazeite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chekazeite.isChecked()){
                    valorprod += 3;
                }if (!chekazeite.isChecked()) {
                    valorprod -= 3;
                }

                txt_valor.setText("Valor R$ " + valorprod);
            }
        });

        cheknescau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cheknescau.isChecked()){
                    valorprod += 7;
                }if (!cheknescau.isChecked()) {
                    valorprod -= 7;
                }

                txt_valor.setText("Valor R$ " + valorprod);
            }
        });
    }


}