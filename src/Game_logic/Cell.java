package Game_logic;

/**Метод що відпвідає за встановлення різних властивостей комірок*/public class Cell {
    /**змінна, що відповідає за видимість комірки*/
    Boolean isVisible = false;
    /** змінна, що відповідає за плейсхолдер комірки*/
    String placeholder = ".";
    /** змінна, що відповідає за значення комірки*/
    String value = ".";

    /**Метод, що встановлює видимість комірки*/
    public void enableVisibility(){
        isVisible = true;
    }

    /** Метод, що повертає статус комірки*/
    public String getStatus() {
        if(isVisible) {
            return value;
        } else {
            return placeholder;
        }
    }

    /** Метод, що повертає значення комірки*/
    public String getValue() {
        return this.value;
    }

    /** Метод, що встановлює значення комірки*/
    public void setValue(String value) {
        this.value = value;
    }

    /** Метод, що повертає плейсхолдер комірки*/
    public String getPlaceholder() {
        return this.placeholder;
    }

    /**Метод, що встановлює плейсхолдер комірки*/
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}
