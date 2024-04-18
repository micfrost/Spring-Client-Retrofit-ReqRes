package dev.micfro.retrofitca;

public class UserResponse {
    private UserData data;
    private SupportData support;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public SupportData getSupport() {
        return support;
    }

    public void setSupport(SupportData support) {
        this.support = support;
    }

    public static class UserData {
        private int id;
        private String name;
        private int year;
        private String color;
        private String pantone_value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPantoneValue() {
            return pantone_value;
        }

        public void setPantoneValue(String pantone_value) {
            this.pantone_value = pantone_value;
        }
    }

    public static class SupportData {
        private String url;
        private String text;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
