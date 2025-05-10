package co.com.design_patterns.creational.builder;


// Definición de la clase pública Card
public class Card {

    // Atributos privados e inmutables (final) de la tarjeta
    private final String cardType;
    private final String cardNumber;
    private final String cardHolderName;
    private final String expirationDate;
    private final boolean credit;


    // Constructor privado que recibe un objeto CardBuilder
    // Este constructor se usa para crear una instancia de Card a partir del builder

    private Card(CardBuilder builder) {
        this.cardType = builder.cardType;
        this.cardNumber = builder.cardNumber;
        this.cardHolderName = builder.cardHolderName;
        this.expirationDate = builder.expirationDate;
        this.credit = builder.credit;
    }

    // Métodos públicos para acceder a los atributos (getters)
    public String getCardType() {
        return cardType;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public boolean isCredit() {
        return credit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", credit=" + credit +
                '}';
    }

    // Clase interna estática que implementa el patrón Builder
    public static class CardBuilder {
        // Atributos del builder (los mismos que los de Card)
        private String cardType;
        private String cardNumber;
        private String cardHolderName;
        private String expirationDate;
        private boolean credit;

        // Constructor del builder que requiere los campos obligatorios
        public CardBuilder(String cardType, String cardNumber) {
            this.cardType = cardType;
            this.cardNumber = cardNumber;
        }

        // Métodos para establecer los campos opcionales
        // Cada metodo devuelve el builder para permitir encadenamiento (fluent interface)
        public CardBuilder name(String cardHolderName) {
            this.cardHolderName = cardHolderName;
            return this;
        }

        public CardBuilder expirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public CardBuilder credit(boolean credit) {
            this.credit = credit;
            return this;
        }
        // Metodo final que construye el objeto Card usando el builder
        public Card build() {
            return new Card(this);
        }
    }
}
/*
* PATRÓN BUILDER
* Patron de diseño creacional, usado para construir objetos complejos paso a paso, especialmente cuando:
*   * Hay muchos atributos (algunos opcionales)
*   * No queremos tener constructores con muchos parámetros(lo que se llama "Constructor telescopico")
*   * No queremos que el objeto final sea inmutable (No se pueda modificar despues de crearlo)
*
* PASO A PASO DEL FUNCIONAMIENTO
*
*   1. DEFINICIÓN DE LA CLASE CARD
*       * Se definen los atributos de la tarjeta
*       * Son private (encapsulados) y final (No se pueden cambiar despues de asignarlos)
*       * Esto garantiza que el objeto sea inmutable
*
*   2. CONSTRUCTOR PRIVADO
*       * Este constructor no se puede llamar directamente desde afuera de la clase
*       * Solo se puede usar desde el metodo build() del CardBuilder
*       * Toma los valores del builder y los asigna a los atributos de Card.
*
*   3. GETTERS
*       * Permiten acceder a los valores de los atributos
*       * No hay setters porque no queremos que se modifiquen despues de crear la tarjeta.
*
*   4.  CLASE INTERNA CARDBUILDER
*       * Es una clase estática interna que se usa para construir objetos Card.
*       * Tiene los mismos atributos que Card, pero no son final porque se pueden modificar durante la construcción.
*
*   5. CONSTRUCTOR DEL BUILDER
*       * Este constructor obliga a pasar los campos esenciales (tipo y número de tarjeta).
*       * Así se asegura que el objeto Card siempre tenga esos datos.
*
    6. METODOS DEL BUILDER (FLUENT INTERFACE)
*       * Cada metodo asigna un valor a un atributo opcional
*       * Devuelve this para permitir encadenar llamadas
*
*   7. METODO BUILD()
*       * Este metodo crea el objeto Card final usando el constructor privado.
*       * Se asegura de que el objeto esté completamente construido antes de ser usado.
*
* */