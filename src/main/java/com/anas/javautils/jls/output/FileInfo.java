package com.anas.javautils.jls.output;

import java.io.File;

public class FileInfo {
    private final File file;

    public FileInfo(File file) {
        this.file = file;
    }

    public String getPermissions() {
        return file.isDirectory() ? "d" : (file.isFile() ? "-" : "l") +
                (file.canRead() ? "r" : "-") +
                (file.canWrite() ? "w" : "-") +
                (file.canExecute() ? "x" : "-");
    }

    public long getSize() {
        return file.length();
    }

    public String getName() {
        return file.getName();
    }

    public String getCreationTime() {
        return new java.text.SimpleDateFormat("MM dd HH:mm:ss").format(file.lastModified());
    }

    public Icons getIcon() {
        return switch (file.getName()) {
            case "build.gradle", "settings.gradle", "gradlew" -> Icons.GRADLE;
            case "routing.ts", "routing.js", "routing.tsx", "routes.ts",
                    "routes.tsx", "routes.js", "routing.jsx", "routes.jsx" -> Icons.ROUTING;
            case "sln.dotsettings" -> Icons.SETTINGS;
            case "d.ts" -> Icons.TYPESCRIPT_DEF;
            case "vcxitems.filters", "vcxproj.filters" -> Icons.VISUALSTUDIO;
            case "js.map", "mjs.map" -> Icons.JAVASCRIPT_MAP;
            case "css.map" -> Icons.CSS_MAP;
            case "spec.ts", "e2e-spec.ts", "test.ts", "ts.snap" -> Icons.TEST_TS;
            case "spec.tsx", "test.tsx", "tsx.snap", "spec.jsx", "test.jsx", "jsx.snap" -> Icons.TEST_JSX;
            case "spec.js", "e2e-spec.js", "test.js", "js.snap" -> Icons.TEST_JS;
//            case "tf.json" -> Icons.TERRAFORM;
            case "blade.php", "inky.php" -> Icons.LARAVEL;
            case "gitlab-ci.yml" -> Icons.GITLAB;
            /*case "stories.js", "stories.jsx", "story.js", "story.jsx",
                    "stories.ts", "stories.tsx", "story.ts", "story.tsx" -> Icons.STORYBOOK;*/
            case "azure-pipelines.yml", "azure-pipelines.yaml" -> Icons.AZURE_PIPELINES;
        };
    }
}
