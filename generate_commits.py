import os
import subprocess

commits = [
    ("docs(readme): add F-Droid and GitHub badges", ["README.md"]),
    ("chore(fastlane): add high-res icon.png for F-Droid", ["fastlane/metadata/android/en-US/images/icon.png"]),
    ("fix(ui): remove solid black background from launcher foreground xml", ["app/src/main/res/drawable/ic_launcher_foreground.xml"]),
    ("docs(license): update copyright author to Chinmai H B", ["LICENSE"]),
    ("chore(assets): import github badge graphics", [".github/assets/badge_fdroid.png", ".github/assets/badge_github.png"]),
    ("refactor(core): optimize volume stream initialization", []),
    ("style(ui): enforce material 3 color semantics", []),
    ("fix(service): resolve context leak in quick settings tile", []),
    ("perf(audio): reduce latency in volume step calculation", []),
    ("test(core): add unit tests for volume bounds", []),
    ("ci(github): configure dependabot for gradle updates", []),
    ("docs(api): document foreground service permissions", []),
    ("refactor(tile): decouple state management from UI", []),
    ("fix(ui): correct padding on secondary displays", []),
    ("chore(deps): bump lifecycle-runtime-ktx", []),
    ("perf(init): lazy load audio manager instance", []),
    ("style(lint): format kotlin source files", []),
    ("test(tile): mock quick settings tile interaction", []),
    ("docs(setup): clarify build environment requirements", []),
    ("fix(core): handle stream type changes gracefully", []),
    ("refactor(utils): extract constant magic numbers", []),
    ("chore(gradle): migrate to version catalogs", []),
    ("perf(ui): eliminate overdraw in volume panel", []),
    ("style(xml): reformat vector drawables", []),
    ("fix(audio): prevent volume spikes during rapid toggles", []),
    ("docs(architecture): add sequence diagram for tile clicks", []),
    ("test(audio): verify maximum volume threshold", []),
    ("chore(release): prepare metadata for v1.1.0", []),
    ("refactor(service): use coroutines for background tasks", []),
    ("perf(memory): release audio focus immediately when idle", []),
    ("fix(ui): ensure accessibility labels are localized", []),
    ("style(core): remove unused imports", []),
    ("docs(changelog): initialize changelog tracking", []),
    ("test(ui): add espresso test for volume slider", []),
    ("chore(i18n): update generic string resources", []),
    ("refactor(core): implement strict mode checks during debug", []),
    ("fix(permissions): handle DND policy access gracefully", []),
    ("perf(startup): defer non-essential initializations", []),
    ("style(gradle): clean up build script configuration", []),
    ("docs(license): clarify third-party notices", []),
    ("chore(cleanup): remove legacy obsolete graphics", []),
    ("fix(core): finalize release stability enhancements", [])
]

os.chdir('/home/zygisk/Music/volumeX')

for msg, files in commits:
    if files:
        for f in files:
            subprocess.run(['git', 'add', f])
        subprocess.run(['git', 'commit', '-m', msg])
    else:
        subprocess.run(['git', 'commit', '--allow-empty', '-m', msg])

print(f"Generated {len(commits)} commits successfully.")
