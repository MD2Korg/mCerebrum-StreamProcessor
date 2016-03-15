# mCerebrum:StreamProcessor
[![Build Status](https://travis-ci.org/MD2Korg/mCerebrum-StreamProcessor.svg?branch=master)](https://travis-ci.org/MD2Korg/mCerebrum-StreamProcessor)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/57cc37adf19242209da1a26c9df700ca)](https://www.codacy.com/app/twhnat/mCerebrum-StreamProcessor)

# Overview
StreamProcessor is a real-time processing pipeline for AutoSense chest and wrist sensors.  It implements the following algorithms:
- cStress: A continuous stress assessment algorithm

## References
- [UbiComp 2015](http://ubicomp.org/ubicomp2015/program/accepted-papers.html)
*cStress: Towards a Gold Standard for Continuous Stress Assessment in the Mobile Environment*
Karen Hovsepian, Mustafa al'absi, Emre Ertin, Thomas Kamarck, Motoshiro Nakajima, Santosh Kumar [pdf](http://dl.acm.org/citation.cfm?id=2807526)

# Install
Download and install the latest [AutoSense](https://github.com/MD2Korg/mCerebrum-AutoSense/releases/latest) and [StreamProcessor](https://github.com/MD2Korg/mCerebrum-StreamProcessor/releases/latest) applications.

#### Enable unsigned applications
- Go to Settings.
- Select Security.
- On the list, Find Unknown Sources and CHECK the box.
- When done, go back to the folder.
- Tap on the apk file and select Open/Install. It should be able to install.

# Usage
<!-- - Screen shots and basic instructions needed here -->

# Compilation
```
git clone https://github.com/MD2Korg/mCerebrum-Utilities.git
git clone https://github.com/MD2Korg/mCerebrum-DataKitAPI.git
git clone https://github.com/MD2Korg/mCerebrum-StreamProcessor.git
```

MD2K recommends [Android Studio](http://developer.android.com/tools/studio/index.html) to build and evaluate mCerebrum applications.

# Training
- [mCerebrum Documentation](https://mhealth.md2k.org/)
- [Support forum](https://mhealth.md2k.org/)

# Release History
- `0.1.0` Initial release

# Contributors
- Monowar Syed Hossain ([monowar](https://github.com/monowar)) <monowar.hossain@gmail.com>
- Timothy Hnat ([twhnat](https://github.com/twhnat)) <twhnat@memphis.edu>

# License
[BSD 2-Clause](LICENSE)

# Support
This research was supported by grant U54EB020404 awarded by the National Institute of Biomedical Imaging and Bioengineering (NIBIB) through funds provided by the trans-NIH Big Data to Knowledge (BD2K) initiative ([www.bd2k.nih.gov](http://www.bd2k.nih.gov)).
