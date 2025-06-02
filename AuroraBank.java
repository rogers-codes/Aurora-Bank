    package AuroraBank;

    import java.util.Scanner;

    public class AuroraBank {
        public static void main(String[] args) {

            Scanner leitor = new Scanner(System.in);
            long CPFusuario = 57764448894L;
            long CPFdigitado = 0;
            int option = 0;
            int saldo = 2000;
            int transf = 0;
            int senhaUsuario = 0000;
            int senhaDigitada = 0;
            int recebe = 0;
            int provedTransf = 1234;
            int provedDigitado = 0;
            int tentativas = 4;

            String tipConta = "Corrente";
            String nomeConta = "Rogério augusto dos santos júnior";


                System.out.println("""
                        **************************************************************
                        Bem vindo ao Aurora Bank Rogério!,para acessar sua conta digite seu cpf:
                        **************************************************************
                        """);
                CPFdigitado = leitor.nextLong();

            while (CPFdigitado != CPFusuario) {
                System.out.println("Cpf incorreto... digite novamente. ( Limite de tentativas:" + tentativas + ")");
                CPFdigitado = leitor.nextLong();
                if (CPFdigitado != CPFusuario) {
                    tentativas--;
                    if (tentativas == 0) {
                        System.out.println("Conta bloqueada por excesso de tentatativas, Aurora bank encerrado.");
                        return;
                    }
                }
            }


            if (CPFdigitado == CPFusuario) {
                while (option != 4) {
                    System.out.println(String.format("""
                            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                            Titular: %s
                            Tipo de conta: %s
                            Saldo: R$: %d
                            <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                            """, nomeConta, tipConta, saldo));
                    System.out.println("""
                            **********************
                            Qual opção você deseja?
                            
                            1 - Consultar saldo
                            2 - Fazer transferencia
                            3 - Receber transferencia
                            4 - Sair
                            
                            **********************
                            """);
                    option = leitor.nextInt();

                    if (option == 1) { //Vizuaizar saldo do usario
                        System.out.println("Saldo atual: R$" + saldo);
                    }
                    else if (option == 2) {
                        System.out.println("Qual o valor da transferencia?: ");
                        transf = leitor.nextInt();
                        if (saldo < transf ) {
                            while (saldo < transf) {
                                System.out.println("Saldo insuficiente para transferencia, insira um valor menor.");
                                transf = leitor.nextInt();

                            }
                        }  System.out.println("Digite a senha para transferir: ");
                        senhaDigitada = leitor.nextInt();

                        if (senhaDigitada == senhaUsuario) {
                            saldo -= transf;
                            System.out.println(" >>>> Transferencia feita com sucesso, saldo atual: R$" + saldo +"<<<<");
                        } else System.out.println("Senha incorreta!");

                    } else if (option == 3) {
                        System.out.println("Qual o valor a receber?: ");
                        recebe = leitor.nextInt();

                        while (provedDigitado != provedTransf) {
                            System.out.println("Digite o numero da conta do provedor da trasnferencia:");
                            provedDigitado = leitor.nextInt();

                            if (provedDigitado != provedTransf) {
                                System.out.println("Provedor não encontrado... tente novamente!");
                            }
                        }

                        System.out.println("Digite a senha para receber: ");
                        senhaDigitada = leitor.nextInt();
                        if (senhaDigitada == senhaUsuario) {
                            saldo += recebe;
                            System.out.println(" >>>> Valor recebido com sucesso, saldo atual: R$" + saldo +"<<<<");
                        } else System.out.println("Senha incorreta!");


                    } else if (option == 4) {
                        System.out.println("Aurora bank encerrado.");
                        break;
                    } else  {
                        System.out.println("Opção invalida");
                    }

                }




                }
            }
        }
