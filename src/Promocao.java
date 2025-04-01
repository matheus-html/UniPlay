public class Promocao {
    public double descontoCupom(double valor, String cupom){
        switch (cupom){
            case "GAMER10":
                return valor * 0.9;
            case "GAMER20":
                return valor * 0.8;
            case "FREEGAME5":
                return valor * 0.95;
            default:
                return valor;
        }
    }

    public boolean validaCupom(String cupom){
        if(cupom.equals("GAMER10")){
            return true;
        } else if(cupom.equals("GAMER20")){
            return true;
        } else if(cupom.equals("FREEGAME5")){
            return true;
        } else {
            return false;
        }
    }
}
